#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[])
{
    int length = argc - 1;
    int values[10];
    int odd = 0;
    int i;

    for (i = 0; i < length; i++)
    {
        values[i] = atoi(argv[i + 1]);
    }

    for (i = 0; i < length; i++)
    {
        if (values[i] % 2 == 1)
        {
            odd++;
        }
    }
    printf("%d\n", odd);
    return 0;
}