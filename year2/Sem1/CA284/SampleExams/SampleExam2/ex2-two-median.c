#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


void BubbleSort(int *array, int size);
void getMiddleNums(int *array, int size, int *n1, int *n2);

int main(int argc, char*argv[])
{
    int NumArray[argc - 1];
    for (int i = 0; i < argc - 1; ++i)
    {
        NumArray[i] = atoi(argv[i + 1]);
    }
    int size = sizeof(NumArray)/sizeof(NumArray[0]);
    int n1;
    int n2;
    BubbleSort(NumArray, size);
    getMiddleNums(NumArray, size, &n1, &n2);

    printf("%d\n", n1);
    printf("%d\n", n2);
    return 0;
}

void BubbleSort(int *array, int size)
{
    for (int i = 0; i < size - 1; ++i)
    {
        for (int j = 0; j < size - 1 - i; ++j)
        {
            if ((array[j]) < (array[j + 1]))
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
void getMiddleNums(int *array, int size, int *n1, int *n2)
{
    int middle = size / 2;
    *n1 = (array[middle]); 
    *n2 = (array[middle - 1]);
}