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
void addCountries(Country *countries, int numCountries, char *strings[])
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
}
void FormatFunction(Country countries)
{
    printf("%s\t\t\t", countries.name);
    printf("%s\t\t\t", countries.capital);
    printf("%d\t\t\t", countries.size);
    printf("%.2f\n", countries.population);
}

void SelectionSort(float *PopulationArray, int size)
{
    for (int i = 0; i < size; ++i)
    {
        int max_index = i;              // assumed as max number for now, index 0 in array
        for (int j = i + 1; j < size; ++j)
        {
            if (*(PopulationArray + j) > *(PopulationArray + max_index))                // compares value at index j with value at max index
            {
                max_index = j;
            }
        }
        float temp = *(PopulationArray + i);
        *(PopulationArray + i) = *(PopulationArray + max_index);
        *(PopulationArray + max_index) = temp;
    }
}

void sortCountries(Country *countries, int numCountries)
{
    float PopulationArray[numCountries];
    for (int i = 0; i < numCountries; ++i)
    {
        PopulationArray[i] = countries[i].population;
    }
    int size = sizeof(PopulationArray)/sizeof(PopulationArray[0]);
    SelectionSort(PopulationArray, size);
    for (int i = 0; i < size; ++i)
    {
        float Population = PopulationArray[i];
        for (int j = 0; j < size; ++j)
        {
            if (countries[j].population == Population)
            {
                FormatFunction(countries[j]);
            }
        }
    }
}

int main(int argc, char*argv[])
{
    struct Country countries[50];
    int numCountries = (argc - 1) / 4;
    char *strings[argc - 1];
    for (int i = 0; i < argc; ++i)
    {
        strings[i] = argv[i + 1];
    }
    addCountries(countries, numCountries, strings);
    printf("Country\t\t\tCapital\t\t\tSize\t\t\tPopulation\n");
    sortCountries(countries, numCountries);
    return 0;
}