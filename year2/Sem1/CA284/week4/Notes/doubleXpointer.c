#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void doubleX(int *x);

int main(int argc, char* argv[])
{
    int x = atoi(argv[1]);
    printf("Address of pointer before %p\n", &x);
    doubleX(&x);
    printf("%d", x);
    printf("Address of pointer %p\n", &x);
    
}

void doubleX(int *x)
{
    *x = *x * 2;

}
