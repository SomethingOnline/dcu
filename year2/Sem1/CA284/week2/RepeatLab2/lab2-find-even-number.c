#include <stdio.h>
#include <stdlib.h>

int main(int argc, char*argv[])
{
    int length = argc - 1;
    int array[length];
    int evens = 0;
    for(int i = 0; i < length; ++i)
    {
        array[i] = atoi(argv[i + 1]);
    }
    for(int i = 0; i < length; ++i)
    {
        // printf("%d\n", array[i]);
        if (array[i] % 2 == 0)
        {
            evens += 1;
            printf("%d - %d\n", i, array[i]);
        }
    }
    if (evens == 0)
    {
        printf("Not found!\n");
    }
}