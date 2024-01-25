#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int makeMatrix(int size, int matrix[size][size], char *argv[]);
int antiDiag(int size, int *matrix[size][size]);

int main(int argc, char*argv[])
{
    int n = atoi(argv[1]);
    int matrix[n][n];
    int sum = 0;
    makeMatrix(argc - 2, matrix, argv);

    int *pMatrix[n][n];
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            pMatrix[i][j] = &matrix[i][j];
        }
    }
    sum = antiDiag(n, pMatrix);
    printf("%d\n", sum);
    return 0;
}

int makeMatrix(int size, int matrix[size][size], char *argv[])
{
    for (int i = 0; i < size; ++i)
    {
        *(matrix[0] + i) = atoi(argv[i + 2]);
    }
}

int antiDiag(int size, int *matrix[size][size])
{
    int sum = 0;
    for (int i = 0; i < size; ++i)
    {
        sum += *(matrix[i][size - i - 1]);
    }
    return sum;
}