#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void makeThing(double grades[], int argc, char* argv[]);

int main(int argc, char* argv[])
{
    int length = argc - 1;
    double grades[length];
    makeThing(grades, argc, argv);
    for (int i = 0; i < length; ++i)
    {
        printf("%.2lf\n", grades[i]);
    }

}


void makeThing(double grades[], int argc, char*argv[])
{
    for (int i = 0; i < argc - 1; ++i)
    {
        grades[i] = atof(argv[i + 1]);
    }
}