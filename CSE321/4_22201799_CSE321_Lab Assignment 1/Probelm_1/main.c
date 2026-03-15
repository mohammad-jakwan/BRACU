#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

struct data {
    int *arr;
    int n;
    int *q;
    int s;
};

void* make_fib(void* p) {
    int n = *(int*)p;
    int *fib = (int*)malloc((n + 1) * sizeof(int));
    int i;
    fib[0] = 0;
    if (n >= 1) {
        fib[1] = 1;
    }
    for (i = 2; i <= n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }


        return (void*)fib;
}

void* search_fib(void* p){
    struct data *d = (struct data*)p;
    int *ans = (int*)malloc(d->s * sizeof(int));
    int i;
    int val;

    for(i = 0; i < d->s; i++){
        val = d->q[i];

        if (val >= 0 && val <= d->n) {
            ans[i] = d->arr[val];
        } else {
            ans[i] = -1;
        }
}

        return (void*)ans;
}

int main(){
    int n, s, i;
    int *q;
    pthread_t t1, t2;
    int *res1, *res2;
    struct data d;

    printf("Enter the term of fibonacci sequence:\n");
    scanf("%d", &n);

    printf("How many numbers you are willing to search?:\n");
    scanf("%d", &s);

    q = (int*)malloc(s * sizeof(int));

    for (i = 0; i < s; i++){
        printf("Enter search %d:\n", i + 1);
        scanf("%d", &q[i]);
    }
    pthread_create(&t1, NULL, make_fib, &n);
    pthread_join(t1, (void**)&res1);

    for(i = 0; i <= n; i++) {
        printf("a[%d]=%d\n", i, res1[i]);
    }
    d.arr = res1;
    d.n = n;
    d.q = q;
    d.s = s;

    pthread_create(&t2, NULL, search_fib, &d);
    pthread_join(t2, (void**)&res2);

    for (i = 0; i < s; i++) {
        printf("result of search #%d=%d\n", i + 1, res2[i]);
    }
        return 0;
}
