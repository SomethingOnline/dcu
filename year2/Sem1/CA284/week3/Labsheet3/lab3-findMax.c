#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int findMax(int numbers[], int length);

int main(int argc, char*argv[])
{
    int length = argc - 1;
    int numbers[length];
    for (int i = 0; i < length; ++i)
    {
        numbers[i] = atoi(argv[i + 1]);
    }
    int sum = findMax(numbers, length);
    printf("%d\n", sum);
}

int findMax(int numbers[], int length)
{
    int largest = numbers[0];
    for (int i = 1; i < length; ++i)
    {
        int currNum = numbers[i];
        if (currNum > largest)
        {
            largest = currNum;
        }
    }
    return largest;
}