#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415

int main(int argc, char*argv[])
{
    int radius, height, length;
    length = argc - 1;
    if (length == 0)
    {
        printf("No input given!");
    }
    else if (length == 1)
    {
        printf("Two arguments needed!");
    }
    else
    {
        radius = atoi(argv[1]);
        height = atoi(argv[2]);
        if (radius < 0 || height < 0)
        {
            printf("The radious or height cannot be negative!");
        }
        else 
        {
            float area;
            area = (2 * PI * radius * height) + (2 * PI * (radius * radius));
            printf("%.2f\n", area);
        }
    }

}