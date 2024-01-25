#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(int argc, char * argv[])
{
    int x = 10;
    int y = 1;
    x ^= y;
    y = x ^ y;
    x ^= y;
    printf("%d\n%d\n", x, y);
}