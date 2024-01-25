#include <stdio.h>
#include <stdlib.h>

void assign_values(int*, char*[]);
void print_freq(int *frequent, int *freq_num);
void get_freq_nums(int *numArray, int **frequent, int *size, int *freq_num);
void add_memory(int **numArray, int *argc, int *size, char *argv[]);
void sort_list(int *numArray, int *size);
void add_freq_nums(int **frequent, int *prev, int *count, int *freq_num, int *index);

int main(int argc, char *argv[])
{
    int *numArray = NULL;
    int size = 5;
    numArray = (int*)calloc(5, sizeof(int));
    if(!numArray)
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }
    assign_values(numArray, argv);
    if ((argc - 1) > size)
    {
        add_memory(&numArray, &argc, &size, argv);
    }
    sort_list(numArray, &size);
    int *frequent = NULL, 
    freq_num = 1;
    frequent = (int*)calloc(freq_num, sizeof(int));
    if(!frequent)
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }
    get_freq_nums(numArray, &frequent, &size, &freq_num);
    print_freq(frequent, &freq_num);
    free(frequent);
    free(numArray);
    return 0;
}

void assign_values(int *numArray, char *argv[])
{
    for(int i = 0; i < 5; ++i)
    {
        numArray[i] = atoi(argv[i + 1]);
    }
}

void add_memory(int **numArray, int *argc, int *size, char *argv[])
{
    for (int i = 5; i < *argc - 1; ++i)
    {
        *size = *size + 1;
        int *temp = realloc(*numArray, (*size) * sizeof(int));
        if (!temp)
        {
            printf("Memory allocation failed\n");
        }
        *numArray = temp;
        (*numArray)[*size - 1] = atoi(argv[i + 1]);
    }
}

void sort_list(int *numArray, int *size)
{
    for(int i = 0; i < *size - 1; ++i)
    {
        for(int j = 0; j < *size - i - 1; ++j)
        {
            if(numArray[j] > numArray[j + 1])
            {
                int temp = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = temp;
            }
        }
    }
}
void get_freq_nums(int *numArray, int **frequent, int *size, int *freq_num)
{
    int count = 1;
    int prev = numArray[0];
    int index = 0;
    for(int i = 1; i < *size; ++i)
    {
        if(prev == numArray[i])
        {
            count++;
        }
        else
        {
            if(count > 3)
            {
                add_freq_nums(frequent, &prev, &count, freq_num, &index);
            }
            count = 1;
        }
        prev = numArray[i];
    }
    if(count > 3)
    {
        add_freq_nums(frequent, &prev, &count, freq_num, &index);
    }
}

void add_freq_nums(int **frequent, int *prev, int *count, int *freq_num, int *index)
{
    for(int i = 0; i < *count; ++i, *index += 1)
    {
        *freq_num += 1;
        int *temp = realloc(*frequent, (*freq_num)*sizeof(int));
        if (!temp) 
        {
            printf("Memory allocation failed, exiting...\n");
            exit(0);
        }
       *frequent = temp;
       (*frequent)[*index] = *prev;
    }
}

void print_freq(int *frequent, int *freq_num)
{
    for(int i = 0; i < *freq_num - 1; ++i)
    {
        printf("%d\n", frequent[i]);
    }
}