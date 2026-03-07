#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

sem_t s;
sem_t a;
sem_t b;
sem_t c;
pthread_mutex_t m;
char* temp1;
char* temp2;
int flag = 0;

void* supp(void* arg) {
    int *ptr;
    int n;
    int i;
    int x;

    ptr = (int*)arg;
    n = *ptr;

    for(i = 0; i < n; i = i + 1) {
        sem_wait(&s);
        pthread_mutex_lock(&m);
        if (i > 0) {
            printf("\n");
        }
    x = i % 3;
    if (x == 0) {
            temp1 = "Bread";
            temp2 = "Cheese";
            printf("Supplier places: %s and %s\n", temp1, temp2);
            pthread_mutex_unlock(&m);
            sem_post(&c);
        }
    else if (x == 1) {
            temp1 = "Cheese";
            temp2 = "Lettuce";
            printf("Supplier places: %s and %s\n", temp1, temp2);
            pthread_mutex_unlock(&m);
            sem_post(&a);
        }
    else if (x == 2) {
            temp1 = "Bread";
            temp2 = "Lettuce";
            printf("Supplier places: %s and %s\n", temp1, temp2);
            pthread_mutex_unlock(&m);
            sem_post(&b);
        }
    }

        sem_wait(&s);
        flag = 1;

    sem_post(&a);
    sem_post(&b);
    sem_post(&c);
    return NULL;
}

void* makerA(void* arg) {
    int is_running;
    is_running = 1;

while(is_running == 1) {
        sem_wait(&a);
        if(flag == 1) {
            is_running = 0;
            break;
        }

        pthread_mutex_lock(&m);
        printf("Maker A picks up %s and %s\n", temp1, temp2);
        temp1 = NULL;
        temp2 = NULL;
        pthread_mutex_unlock(&m);

        printf("Maker A is making the sandwich...\n");
        printf("Maker A finished making the sandwich and eats it\n");
        printf("Maker A signals Supplier\n");
        sem_post(&s);
    }

       return NULL;
}

void* makerB(void* arg) {
    int is_running;
    is_running = 1;

    while (is_running == 1) {
        sem_wait(&b);

        if (flag == 1) {
            is_running = 0;
            break;
        }
        pthread_mutex_lock(&m);
        printf("Maker B picks up %s and %s\n", temp1, temp2);
        temp1 = NULL;
        temp2 = NULL;
        pthread_mutex_unlock(&m);

        printf("Maker B is making the sandwich...\n");
        printf("Maker B finished making the sandwich and eats it\n");
        printf("Maker B signals Supplier\n");
        sem_post(&s);
    }

    return NULL;
}

void* makerC(void* arg) {
    int is_running;
    is_running = 1;

    while(is_running == 1) {
        sem_wait(&c);

    if(flag == 1) {
        is_running = 0;
        break;
        }

        pthread_mutex_lock(&m);
        printf("Maker C picks up %s and %s\n", temp1, temp2);
        temp1 = NULL;
        temp2 = NULL;
        pthread_mutex_unlock(&m);

        printf("Maker C is making the sandwich...\n");
        printf("Maker C finished making the sandwich and eats it\n");
        printf("Maker C signals Supplier\n");

        sem_post(&s);
    }

    return NULL;
}

int main() {
    int n;
    int check;

    pthread_t t1;
    pthread_t t2;
    pthread_t t3;
    pthread_t t4;
    temp1 = NULL;
    temp2 = NULL;

    check = scanf("%d", &n);

    if (check != 1) {
        return 1;
    }
        sem_init(&s, 0, 1);
        sem_init(&a, 0, 0);
        sem_init(&b, 0, 0);
        sem_init(&c, 0, 0);

        pthread_mutex_init(&m, NULL);

        pthread_create(&t1, NULL, supp, &n);
        pthread_create(&t2, NULL, makerA, NULL);
        pthread_create(&t3, NULL, makerB, NULL);
        pthread_create(&t4, NULL, makerC, NULL);

        pthread_join(t1, NULL);
        pthread_join(t2, NULL);
        pthread_join(t3, NULL);
        pthread_join(t4, NULL);

        sem_destroy(&s);
        sem_destroy(&a);
        sem_destroy(&b);
        sem_destroy(&c);

    pthread_mutex_destroy(&m);

    return 0;
}
