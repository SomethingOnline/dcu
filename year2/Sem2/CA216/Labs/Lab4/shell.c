#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>
#include <string.h>
extern char **environ;

// Signal handler function
void sigint_handler(int signum) {
    printf("Received a signal %d\n", signum);
}

int main(int argc, char *argv[]) {
    // Set up signal handler
    signal(SIGINT, sigint_handler);

    char input[100];

    // Start shell loop
    while (1) {
        printf("Shell> ");
        fgets(input, sizeof(input), stdin);
        // Remove newline character
        input[strcspn(input, "\n")] = '\0';

        // Tokenize input to extract command
        char *command = strtok(input, " ");
        if (command == NULL) {
            printf("No command provided.\n");
            continue;
        }

        // Compare command with known commands
        if (strcmp(command, "quit") == 0) {
            printf("Exiting the shell.\n");
            break;
        } else if (strcmp(command, "cd") == 0) {
            // Change directory
            char *directory = strtok(NULL, " ");
            if (directory == NULL) {
                printf("Usage: cd <directory>\n");
            } else {
                if (chdir(directory) != 0) {
                     perror("chdir() error");
                }
            }
        } else if (strcmp(command, "clr") == 0) {
            system("clear");
        } else if (strcmp(command, "dir") == 0) {
            char *directory = strtok(NULL, " ");
            if (directory == NULL) {
                system("ls -al");
            } else {
                char command[100];
                snprintf(command, sizeof(command), "ls -al %s", directory);
                system(command);
            }
        } else if (strcmp(command, "environ") == 0) {
            for (int i = 0; environ[i] != NULL; ++i) {
                printf("%s\n", environ[i]);
            }
        } else {
            printf("Command not recognized: %s\n", command);
        }
    }

    return 0;
}
