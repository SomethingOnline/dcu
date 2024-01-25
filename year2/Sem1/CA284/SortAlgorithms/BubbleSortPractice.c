#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>


void BubbleSort(int array[], int size);
int main(int argc, char *argv[])
{
    int NumArray[10] = {8, 5, 4, 2, 1, 6, 7, 9, 10, 3};
    int size = sizeof(NumArray)/sizeof(NumArray[0]);
    printf("Size: %d\n", size);
    BubbleSort(NumArray, size);
    for (int i = 0; i < size; ++i)
    {
        printf("%d\n", NumArray[i]);
    }
    
}

void BubbleSort(int array[], int size)
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