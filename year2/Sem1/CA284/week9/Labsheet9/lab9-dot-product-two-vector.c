#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void fillArray(int *array,char *argv[], int size, int index);
void dotProduct(int *array1, int *array2, int size, int *result);

int main(int argc, char *argv[])
{
    int *pVector1 = NULL;
    int *pVector2 = NULL;
    int *pResult = NULL;

    int size = atoi(argv[1]);
    int index = 2;
    pVector1 = calloc(size, sizeof(int));
    pVector2 = calloc(size, sizeof(int));
    if (!pVector1 || !pVector2)
    {
        printf("Failed to allocate memory");
        return 0;
    }
    fillArray(pVector1, argv, size, index);

    fillArray(pVector2, argv, size, index + size);

    pResult = calloc(1, sizeof(int));

    dotProduct(pVector1, pVector2, size, pResult);
    printf("%d\n", *pResult);
    free(pResult);
    pResult = NULL;
    free(pVector1);
    pVector1 = NULL;
    free(pVector2);
    pVector2 = NULL;
    return 0;
}

void fillArray(int *array, char*argv[], int size, int index)
{
    for (int i = 0; i < size; ++i)
    {
        array[i] = atoi(argv[i + index]);
    }
}

void dotProduct(int *array1, int *array2, int size, int *result)
{
    for (int i = 0; i < size; ++i)
    {
        *result += (array1[i] * array2[i]);
    }
}