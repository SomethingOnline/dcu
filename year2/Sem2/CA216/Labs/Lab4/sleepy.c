#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>

// Signal handler function
void sigint_handler(int signum) {
    printf("Received a signal %d\n", signum);
}

int main(int agrc, char * argv[]){

    int n = atoi(argv[1]);
    unsigned int sleep(unsigned int seconds);
    pid_t getpid(void);

    signal(SIGINT, sigint_handler);
    printf("I am the process %d\n", getpid());

    int remaining;
    remaining = sleep(atoi(argv[1]));

    for (int i = 0; i < n; ++i){
        printf("%d", getpid());
        sleep(5);
        printf("Time remaining %d\n", remaining);
    }

    return 0;
}