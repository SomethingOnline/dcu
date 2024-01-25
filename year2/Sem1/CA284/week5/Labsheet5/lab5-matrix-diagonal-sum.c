#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


int main(int argc, char*argv[])
{
    int dimensions = atoi(argv[1]);
    int matrix[dimensions][dimensions];
    int sum = 0;

    int matrixList[argc - 2];
    for (int i = 2; i < argc; ++i)
    {
        matrixList[i - 2] = atoi(argv[i]);
    }
    for (int i = 0; i < argc - 2; ++i)
    {
        *(matrix[0] + i) = matrixList[i];
    }

    for (int i = 0; i < dimensions; ++i)
    {
        sum += matrix[i][i];
    }

    printf("%d\n", sum);
    return 0;

}