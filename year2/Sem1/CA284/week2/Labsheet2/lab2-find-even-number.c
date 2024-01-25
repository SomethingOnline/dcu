#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[])
{
    int length = argc - 1;
    int values[10];
    int even = 0;
    int i;

    for (i = 0; i < length; i++)
    {
        values[i] = atoi(argv[i + 1]);
    }

    for (i = 0; i < length; i++)
    {
        if (values[i] % 2 == 0)
        {
            printf("%d - %u\n", i, values[i]);
            even++;
        }
    }
    if (even == 0)
    {
        printf("Not found!\n");
    }

    return 0;
}