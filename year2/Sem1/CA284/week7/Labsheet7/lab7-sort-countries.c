#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Country Country;
struct Country
{
    char name[50];
    char capital[50];
    float population;
    int size;
};
void addCountries(Country *countries, char*strings[], int numCountries)
{
    int index = 0;
    for (int i = 0; i < numCountries; ++i)
    {
        strcpy(countries[i].name, strings[index]);
        strcpy(countries[i].capital, strings[index + 1]);
        countries[i].population = atof(strings[index + 2]);
        countries[i].size = atoi(strings[index + 3]);

        index += 4;
    }
};
void FormatFunction(Country *countries, int numCountries)
{
    for (int i = 0; i < numCountries; ++i)
    {
        printf("%s\t\t\t", countries[i].name);
        printf("%s\t\t\t", countries[i].capital);
        printf("%d\t\t\t", countries[i].size);
        printf("%.2f\n", countries[i].population);
    }
};

void selectionSort(Country *countries, int numCountries) {
    int i, j, max_index;
    Country temp;

    for (i = 0; i < numCountries - 1; ++i) {
        max_index = i;

        for (j = i + 1; j < numCountries; ++j) {
            if (countries[j].population > countries[max_index].population) {
                max_index = j;
            }
        }

        if (max_index != i) {
            temp = countries[i];
            countries[i] = countries[max_index];
            countries[max_index] = temp;
        }
    }
}

int main(int argc, char*argv[])
{
    char *strings[argc - 1];
    Country countries[50];
    int numCountries = (argc - 1) / 4;
    char *newArray[numCountries];
    for (int i = 0; i < argc; ++i)
    {
        strings[i] = argv[i + 1];
    }
    printf("Country\t\t\tCapital\t\t\tSize\t\t\tPopulation\n");
    addCountries(countries, strings, numCountries);
    selectionSort(countries, numCountries);
    FormatFunction(countries, numCountries);
}
