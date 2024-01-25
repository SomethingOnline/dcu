#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char*argv[])
{
    int length = argc - 1;
    int numbers[length];
    int dupeNum = 0;
    int newList[length];
    for (int i = 0; i < length; ++i)
    {
        numbers[i] = atoi(argv[i + 1]);
    }
    // numbers = 4 9 12 5 7 8 4 13
    for (int i = 0; i < length - 1; ++i)
    {
        for (int j = i + 1; j < length; ++j)
        {
            if (numbers[i] == numbers[j])
            {
                printf("%d\n", numbers[j]);
                dupeNum += 1;
                exit(0);
            }
        }
    }
    if (dupeNum == 0)
    {
        printf("no duplicated number\n");
    }
}