#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Country Country;
typedef struct City City;
struct City
{
    char name[50];
    int size;
};

struct Country
{
    char name[50];
    City cities[3];
};

void addCountries(Country *countries, char *name, City city1, City city2, City city3, index)
{

}

int main(int argc, char*argv[])
{
    Country countries[50];
    City cities[50];
    
    char *strings[argc - 1];
    for (int i = 0; i < argc; ++i)
    {
        strings[i] = argv[i + 1];
    }

    addCountries(countries, countries.name, )

    // for (int i = 0; i < argc - 1; ++i)
    // {
    //     printf("%s\n", strings[i]);
    // }
    // 3 cities for country

}