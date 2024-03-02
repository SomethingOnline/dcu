/**
 * This program forks a separate process 
 * using the fork()/exec() system calls.
 *
 * Figure 3.08
 *
 * @author Silberschatz, Galvin, and Gagne
 * Operating System Concepts  - Tenth Edition
 * Copyright John Wiley & Sons - 2018
 */

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;
    int status;
    pid_t cpid;

	/* fork a child process */
	pid = fork();

    // error checking the forked child process
    // no error = pid > 0
	if (pid < 0) { /* error occurred */
		fprintf(stderr, "Fork Failed\n");
		return 1;
	}
    // if pid == 0, we are in the child process
	else if (pid == 0) { /* child process */
		printf("I am the child %d\n",pid);
		// infinite loop so we can examine processes
		while(1);
		// execlp("/bin/ls","ls",NULL);
    // this line will never be executed because exec() replaces the current process
    // this means after fork, the process ic replaced meaning the line underneath
    // is now replaced too.
        // printf("Do i execute?");
	}
    // if pid > 1 we are in the parent process
	else { /* parent process */
		/* parent will wait for the child to complete */
		printf("I am the parent %d\n",pid);
		// infinite loop so we can examine process
		while(1);

		wait(NULL);
        printf("Child complete\n");
	}
    
    return 0;
}