#include <stdio.h>
#include <stdlib.h>
#include <string.h>


float getLargest(float floatArray[], int length);
float getSmallest(float floatArray[], int length);

int main(int argc, char*argv[])
{
    float floatArray[50];
    int length = argc - 2;
    float sum;

    char myOperation[10];
    strcpy(myOperation, argv[1]);

    for (int i = 2; i < argc; ++i)
    {
        // printf("%s\n", argv[i]);
        floatArray[i - 2] = atof(argv[i]);
    }

    if (strcmp(myOperation, "largest") == 0)
    {
        sum = getLargest(floatArray, length);
        printf("%.2lf\n", sum);
    }
    if (strcmp(myOperation, "smallest") == 0)
    {
        sum = getSmallest(floatArray, length);
        printf("%.2lf\n", sum);
    }

}


float getLargest(float floatArray[], int length)
{
    float largest;
    largest = floatArray[0];
    for (int i = 1; i < length; ++i)
    {
        if (floatArray[i] > largest)
        {
            largest = floatArray[i];
        }
    }
    return largest;
}

float getSmallest(float floatArray[], int length)
{
    float smallest;
    smallest = floatArray[0];
    for (int i = 1; i < length; ++i)
    {
        if (floatArray[i] < smallest)
        {
            smallest = floatArray[i];
        }
    }
    return smallest;
}