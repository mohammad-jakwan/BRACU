#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <unistd.h>

struct process {
    int p_id;
    int parent_id;
    char st[20];
    int ex_status;
    int alive;
};

struct process table[64];
int next_id = 2;

pthread_mutex_t m = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t wait_c = PTHREAD_COND_INITIALIZER;
pthread_cond_t mon_c1 = PTHREAD_COND_INITIALIZER;
pthread_cond_t mon_c2 = PTHREAD_COND_INITIALIZER;

int ready = 0;
int over = 0;
char msg[300];

FILE *fp;

struct args {
    int id;
    char fname[100];
};

void tell_monitor(char *m_str) {
    strcpy(msg, m_str);
    ready = 1;
    pthread_cond_signal(&mon_c1);
    
    while(ready == 1 && over == 0) {
        pthread_cond_wait(&mon_c2, &m);
    }
}

void pm_fork(int ppid, int tid) {
    pthread_mutex_lock(&m);
    
    int empty_index = -1;
    for(int i = 0; i < 64; i++) {
        if(table[i].alive == 0) {
            empty_index = i;
            break;
        }
    }

    if(empty_index != -1) {
        table[empty_index].p_id = next_id;
        next_id = next_id + 1;
        table[empty_index].parent_id = ppid;
        strcpy(table[empty_index].st, "RUNNING");
        table[empty_index].alive = 1;
        
        char text[100];
        sprintf(text, "Thread %d calls pm_fork %d", tid, ppid);
        tell_monitor(text);
    }
    
    pthread_mutex_unlock(&m);
}

void pm_exit(int pid, int stat, int tid) {
    pthread_mutex_lock(&m);
    
    for(int i = 0; i < 64; i++) {
        if(table[i].alive == 1 && table[i].p_id == pid) {
            strcpy(table[i].st, "ZOMBIE");
            table[i].ex_status = stat;
            
            char text[100];
            sprintf(text, "Thread %d calls pm_exit %d %d", tid, pid, stat);
            tell_monitor(text);
            
            pthread_cond_broadcast(&wait_c);
            break;
        }
    }
    
    pthread_mutex_unlock(&m);
}

void pm_wait(int ppid, int child_pid, int tid) {
    pthread_mutex_lock(&m);
    
    for(int i = 0; i < 64; i++) {
        if(table[i].alive == 1 && table[i].p_id == ppid) {
            strcpy(table[i].st, "WAITING");
            break;
        }
    }

    int finish = 0;
    
    while(finish == 0) {
        int found_z = -1;
        int running_child = 0;
        
        for(int i = 0; i < 64; i++) {
            if(table[i].alive == 1 && table[i].parent_id == ppid) {
                if(child_pid == -1 || table[i].p_id == child_pid) {
                    if(strcmp(table[i].st, "ZOMBIE") == 0) {
                        found_z = i;
                    } else {
                        running_child = 1;
                    }
                }
            }
        }
        
        if(found_z != -1) {
            table[found_z].alive = 0;
            
            for(int j = 0; j < 64; j++) {
                if(table[j].alive == 1 && table[j].p_id == ppid) {
                    strcpy(table[j].st, "RUNNING");
                    break;
                }
            }
            
            char text[100];
            sprintf(text, "Thread %d calls pm_wait %d %d", tid, ppid, child_pid);
            tell_monitor(text);
            finish = 1;
            
        } else if(running_child == 1) {
            pthread_cond_wait(&wait_c, &m);
        } else {
            for(int k = 0; k < 64; k++) {
                if(table[k].alive == 1 && table[k].p_id == ppid) {
                    strcpy(table[k].st, "RUNNING");
                    break;
                }
            }
            finish = 1;
        }
    }
    
    pthread_mutex_unlock(&m);
}

void pm_kill(int pid, int tid) {
    pthread_mutex_lock(&m);
    
    for(int i = 0; i < 64; i++) {
        if(table[i].alive == 1 && table[i].p_id == pid) {
            strcpy(table[i].st, "ZOMBIE");
            table[i].ex_status = -1;
            
            char text[100];
            sprintf(text, "Thread %d calls pm_kill %d", tid, pid);
            tell_monitor(text);
            
            pthread_cond_broadcast(&wait_c);
            break;
        }
    }
    
    pthread_mutex_unlock(&m);
}

void pm_ps() {
    fprintf(fp, "%-10s %-10s %-15s %s\n", "PID", "PPID", "STATE", "EXIT STATUS");
    for(int i = 0; i < 64; i++) {
        if(table[i].alive == 1) {
            if(strcmp(table[i].st, "ZOMBIE") == 0) {
                fprintf(fp, "%-10d %-10d %-15s %d\n", table[i].p_id, table[i].parent_id, table[i].st, table[i].ex_status);
            } else {
                fprintf(fp, "%-10d %-10d %-15s -\n", table[i].p_id, table[i].parent_id, table[i].st);
            }
        }
    }
    fprintf(fp, "\n");
    fflush(fp);
}

void* monitor_thread_func(void* a) {
    pthread_mutex_lock(&m);
    
    while(over == 0) {
        while(ready == 0 && over == 0) {
            pthread_cond_wait(&mon_c1, &m);
        }
        
        if(over == 1) {
            break;
        }
        
        fprintf(fp, "%s\n", msg);
        pm_ps();
        
        ready = 0;
        pthread_cond_broadcast(&mon_c2);
    }
    
    pthread_mutex_unlock(&m);
    return NULL;
}

void* worker_thread_func(void* a) {
    struct args* my_args = (struct args*)a;
    int t_id = my_args->id;
    
    FILE* f = fopen(my_args->fname, "r");
    if(f == NULL) {
        return NULL;
    }
    
    char line[200];
    char command[50];
    int num1 = 0;
    int num2 = 0;
    
    while(fgets(line, 200, f)) {
        int read_count = sscanf(line, "%s %d %d", command, &num1, &num2);
        
        if(read_count > 0) {
            if(strcmp(command, "fork") == 0) {
                pm_fork(num1, t_id);
            }
            if(strcmp(command, "exit") == 0) {
                pm_exit(num1, num2, t_id);
            }
            if(strcmp(command, "wait") == 0) {
                pm_wait(num1, num2, t_id);
            }
            if(strcmp(command, "kill") == 0) {
                pm_kill(num1, t_id);
            }
            if(strcmp(command, "sleep") == 0) {
                usleep(num1 * 1000);
            }
        }
    }
    
    fclose(f);
    free(my_args);
    return NULL;
}

// main
int main(int argc, char *argv[]) {
    if(argc < 2) {
        return 0;
    }

    int n_workers = argc - 1;

    for(int i = 0; i < 64; i++) {
        table[i].alive = 0;
    }

    table[0].p_id = 1;
    table[0].parent_id = 0;
    strcpy(table[0].st, "RUNNING");
    table[0].alive = 1;

    fp = fopen("snapshots.txt", "w");

    pthread_t mon_th;
    pthread_create(&mon_th, NULL, monitor_thread_func, NULL);

    usleep(1000); 
    pthread_mutex_lock(&m);
    strcpy(msg, "Initial Process Table");
    ready = 1;
    pthread_cond_signal(&mon_c1);
    while(ready == 1 && over == 0) {
        pthread_cond_wait(&mon_c2, &m);
    }
    pthread_mutex_unlock(&m);

    pthread_t work_th[100]; 
    for(int i = 0; i < n_workers; i++) {
        struct args* a = malloc(sizeof(struct args));
        a->id = i;
        strcpy(a->fname, argv[i+1]);
        pthread_create(&work_th[i], NULL, worker_thread_func, a);
    }

    for(int i = 0; i < n_workers; i++) {
        pthread_join(work_th[i], NULL);
    }

    pthread_mutex_lock(&m);
    over = 1;
    ready = 1; 
    pthread_cond_signal(&mon_c1);
    pthread_mutex_unlock(&m);
    
    pthread_join(mon_th, NULL);

    fclose(fp);
    printf("Simulation completed successfully. Check snapshots.txt for results.\n");

    return 0;
}