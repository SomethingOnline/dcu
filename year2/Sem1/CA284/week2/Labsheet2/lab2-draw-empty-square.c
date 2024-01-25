#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[])
{
    int n = atoi(argv[1]);
    //int i;
    //int j;
    int a, b;

    for (b = 0; b < n; b++)
    {
        printf("*");
    }
    printf("\n");
    for (a = 0; a < n - 2; a++)
    {
        for (b = 0; b < n; b++)
        {
            if ((b == 0) || (b == n - 1))
            {
                printf("*");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    for (b = 0; b < n; b++)
    {
        printf("*");
    }
    printf("\n");
    return 0;
}