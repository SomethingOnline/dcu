#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>



void BubbleSort(int array[], int size);

int main() {
    int NumArray[10] = {8, 5, 4, 2, 1, 6, 7, 9, 10, 3};

    int size = 10;
    int sum = 0;
    BubbleSort(NumArray, size);
    
    for (int i = 0; i < 10; i++) {
        printf("%d\n", NumArray[i]);
    }
    return 0;
}

void BubbleSort(int array[], int size)
{
    for (int i = 0; i < size - 1; ++i)
    {
        for (int j = 0; j < size - i - 1; ++j)
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
