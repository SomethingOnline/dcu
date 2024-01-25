#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_triangular(int num);
int main(int argc, char* argv[])
{
    int num = atoi(argv[1]);
    int result = is_triangular(num);
    if (result == 1)
    {
        printf("%d is a triangular number\n", num);
    }
    else
    {
        printf("%d is not a triangular number\n", num);
    }

}

int is_triangular(int num)
{
    int n = 1;
    int add = 2;
    while (n <= num)
    {
        n = n + add;
        add += 1;
        if (num == n)
        {
            return 1;
        }
    }

}
