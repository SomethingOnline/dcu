#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void populateArray(int *array, char *argv[], int size);
int findLargestTwice(int *array, int size);

int main(int argc, char *argv[])
{
    int size = argc - 1;
    int *array = calloc(size, sizeof(int));

    if (!array)
    {
        printf("memory failed\n");
        return 0;
    }

    populateArray(array, argv, size);

    int twiceLargest = findLargestTwice(array, size);

    printf("%d\n", twiceLargest);

    free(array);
    array = NULL;
    return 0;
}

void populateArray(int *array, char *argv[], int size)
{
    for (int i = 0; i < size; ++i)
    {
        array[i] = atoi(argv[i + 1]);
    }
}

void sortArray(int *array, int size)
{
    for (int i = 0; i < size; ++i)
    {
        for (int j = 0; j < size - 1 - i; ++j)
        {
            if (array[j] < array[j + 1])
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }            
        }
    }
}
int findLargestTwice(int *array, int size)
{  
    sortArray(array, size);
    for (int i = 0; i < size; ++i)
    {
        int checknum = array[i];

        for (int j = 0; j < size; ++j)
        {
            if (((array[j]) * 2) == checknum)
            {
                return checknum;
            }
        }
    }

    return 0;
}