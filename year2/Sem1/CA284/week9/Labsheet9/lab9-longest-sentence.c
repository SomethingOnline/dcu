#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


void populateArray(char **strings, char *argv[], int size);
void getLongest(char **strings, int size, int *longest);
void printLongest(char **strings, int size, int *longest);
int main(int argc, char *argv[])
{
    int size = argc - 1;
    char **array = calloc(size, sizeof(char*));
    int *pLongest = calloc(1, sizeof(int));

    if (!array || !pLongest)
    {
        printf("Memory allocation failed\n");
        return 1;
    }
    
    populateArray(array, argv, size);
    getLongest(array, size, pLongest);
    printLongest(array, size, pLongest);

    free(array);
    array = NULL;
    free(pLongest);
    pLongest = NULL;
}

void populateArray(char **strings, char *argv[], int size)
{
    for (int i = 0; i < size; ++i)
    {
        strings[i] = argv[i + 1];
    }
}
void getLongest(char **strings, int size, int *longest)
{
    *longest = strlen(strings[0]);
    for (int i = 1; i < size; ++i)
    {
        if (strlen(strings[i]) > *longest)
        {
            *longest = strlen(strings[i]);
        }
    }
}
void printLongest(char **strings, int size, int *longest)
{
    for (int i = 0; i < size; ++i)
    {
        if (strlen(strings[i]) == *longest)
        {
            printf("%s\n", strings[i]);
        }
    }
}