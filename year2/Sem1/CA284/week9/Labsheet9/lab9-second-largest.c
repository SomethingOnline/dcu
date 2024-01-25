#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


void populateArray(float *array, char *argv[], int size);
void sort(float *array, int size);
void returnSecLargest(float *array, int size, float *secondLargest);

int main(int argc, char *argv[])
{
    int size = argc - 1;
    float *array = calloc(size, sizeof(float));

    if (!array)
    {
        printf("memory failed\n");
        return 0;
    }

    populateArray(array, argv, size);

    sort(array, size);

    float secondLargest;
    returnSecLargest(array, size, &secondLargest);

    printf("%.1f\n", secondLargest);

    free(array);
    array = NULL;
    return 0;
}

void populateArray(float *array, char *argv[], int size)
{
    for (int i = 0; i < size; ++i)
    {
        array[i] = atof(argv[i + 1]);
    }
}

void returnSecLargest(float *array, int size, float *secondLargest)
{
    float largest = array[0];

    int count = 1;

    for (int i = 1; i < size; ++i)
    {
        if (array[i] == largest)
        {
            count++;
        }
        else
        {
            *secondLargest = array[count];
        }
    }
}

void sort(float *array, int size)
{
    for (int i = 0; i < size; ++i)
    {
        for (int j = 0; j < size - i - 1; ++j)
        {
            if (array[j] < array[j + 1])
            {
                float temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }

        }
    }
}