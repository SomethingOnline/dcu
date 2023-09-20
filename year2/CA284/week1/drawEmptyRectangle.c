#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[])
{
    int column, row, difference;
    
    column = atoi(argv[1]);
    row = atoi(argv[2]);

    difference = column - row;
    printf(difference);

    for(int i = 0; i < column; ++i);
    {
        for(int j = 0; j < row; ++j);
        {
            printf("*");
        }
        printf("\n");
    }
}
