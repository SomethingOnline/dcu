#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void fillAttendances(int *n, char *argv[], char **attendanceArray);
void getStatus(int *n, char **attendanceArray, int *statusArray);
void printStatus(int *n, int *statusArray);
void freeMemory(char **attendanceArray, int* statusArray, int *n);
int main(int argc, char *argv[])
{
    int n = argc - 1;
    int *statusArray;
    char **attendanceArray;
    attendanceArray = (char **)malloc(n * sizeof(char *));
    statusArray = (int *)malloc(n * sizeof(int));
    if (!attendanceArray || !statusArray)
    {
        printf("Allocation failed\n");
        return 0;
    }
    fillAttendances(&n, argv, attendanceArray);
    getStatus(&n, attendanceArray, statusArray);
    printStatus(&n, statusArray);
    freeMemory(attendanceArray, statusArray, &n);
    return 0;
}

void fillAttendances(int *n, char *argv[], char **attendanceArray)
{
    for (int i = 0; i < *n; ++i)
    {
        attendanceArray[i] = (char *)malloc(strlen(argv[i + 1]) + 1);
        if (attendanceArray[i] == NULL) {
            printf("Memory allocation failed\n");
            exit(1);
        }
        strcpy(attendanceArray[i], argv[i + 1]);
    }
}


void getStatus(int *n, char **attendanceArray, int *statusArray)
{
    for (int i = 0; i < *n; ++i)
    {
        int absentCount = 0;
        for (int j = 0; j < strlen(attendanceArray[i]); ++j)
        {
            if (attendanceArray[i][j] == 'A')
            {
                absentCount++;
            }
            else if (attendanceArray[i][j] == 'L')
            {
                if ((j + 2 < strlen(attendanceArray[i])) && (attendanceArray[i][j + 1] == 'L') && (attendanceArray[i][j + 2] == 'L'))
                {
                    absentCount++;
                }
            }
        }
        if (absentCount >= 3)
        {
            statusArray[i] = 1;
        }
        else
        {
            statusArray[i] = 0;
        }
    }
}

void printStatus(int *n, int *statusArray)
{
    for (int i = 0; i < *n; ++i)
    {
        printf("%d\n", statusArray[i]);
    }
}
void freeMemory(char **attendanceArray, int* statusArray, int *n)
{
    for (int i = 0; i < *n; ++i)
    {
        free(attendanceArray[i]);
        attendanceArray[i] = NULL;
    }
    free(attendanceArray);
    attendanceArray = NULL;
    free(statusArray);
    statusArray = NULL;
}