#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Country Country;

struct Country
{
    char name[30];
    char capital[30];
    float population;
    int area;
    
};
void FormatFunction(Country countries, int numCountries)
{
    printf("%s\t\t\t", countries.name);
    printf("%s\t\t\t", countries.capital);
    printf("%d\t\t\t", countries.area);
    printf("%.2f\n", countries.population);
}

float getAverage(Country countries[], int numCountries)
{
    double sum = 0;
    for (int i = 0; i < numCountries; ++i)
    {
        sum += countries[i].population;
    }
    return sum / numCountries;
}
void addCountries(Country *countries, char*strings[], int numCountries)
{   
    int index = 1;
    for (int i = 0; i < numCountries; ++i)
    {
        strcpy(countries[i].name, strings[index - 1]);
        strcpy(countries[i].capital, strings[index]);
        countries[i].population = atof(strings[index + 1]);
        countries[i].area = atoi(strings[index + 2]);

        index += 4;
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
    addCountries(countries, strings, numCountries);
    printf("Country\t\t\tCapital\t\t\tSize\t\t\tPopulation\n");
    for (int i = 0; i < numCountries; ++i)
    {
        FormatFunction(countries[i], numCountries);
    }
    float average = getAverage(countries, numCountries);
    printf("Population average: %.2f\n", average);
    return 0;
}