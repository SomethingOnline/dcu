#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void Sort(int numbers[], int length);

int main(int argc, char*argv[])
{
    int length = argc - 1;
    int numbers[length];
    for (int i = 0; i < length; ++i)
    {
        numbers[i] = atoi(argv[i + 1]);
    }

    Sort(numbers, length);

    for (int i = 0; i < length; ++i)
    {
        printf("%d\n", numbers[i]);
    }
    return 0;
}

void Sort(int numbers[], int length)
{
    for (int i = 0; i < length - 1; ++i)
    {
        // nested loop checks each 
        for (int j = i + 1; j < length; ++j)
        {
            if (numbers[j] < numbers[i])
            {
                int temp;
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }
}