#include <stdio.h>
#include <stdlib.h>

int main(int argc, char*argv[])
{
    int length = argc - 1;
    int array[length];
    for (unsigned int i = 0; i < length; ++i)
    {
        array[i] = atoi(argv[i + 1]);
    }
    int evens = 0;
    for(int i = 0; i < length; ++i)
    {
        if (array[i] % 2 != 0)
        {
            evens += 1;
        } 
    }
    printf("%d\n", evens);
    return 0;
}