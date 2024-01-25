#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[])
{
    int n = atoi(argv[1]);
    printf("%d\n", n);
    while (n != 1)
    {
        if (n % 2 == 0)
        {
            n = n / 2;
            printf("%d ", n);
        }
        else 
        {
            n = n * 3 + 1;
            printf("%d ", n);
        }
    }
}