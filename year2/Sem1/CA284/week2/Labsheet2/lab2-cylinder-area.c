#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415

int main(int argc, char* argv[])
{
    int length = argc - 1;
    if(length == 0){
        printf("No input given!");
    }
    else if (length == 1)
    {
        printf("Two Arguments needed!");
    }
    else{
        int radius, height;
        radius = atoi(argv[1]);
        height = atoi(argv[2]);
        if(height < 0 || radius < 0){
            printf("The radious or height cannot be negative!");
        }
        // A=2πrh+2πr2 //
        else{
        float area;
        area = (2 * PI * radius * height) + (2 * PI * (radius * radius));
        printf("%.2f\n", area);
        // printf("%d\n", radius);
        // printf("%d\n", height);
        }
    }
    
}