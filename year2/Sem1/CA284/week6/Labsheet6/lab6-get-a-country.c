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
void addCountries(Country *countries, char*strings[])
{
    strcpy(countries->name, strings[0]);
    strcpy(countries->capital, strings[1]);
    countries->population = atof(strings[2]);
    countries->area = atoi(strings[3]);
}
void printCountries(Country *countries)
{
    printf("%s\n", countries->name);
    printf("%s\n", countries->capital);
    printf("%.2f million people\n", countries->population);
    printf("%d km2\n", countries->area);

}
int main(int argc, char*argv[])
{
    struct Country countries;
    char *strings[argc - 1];
    for (int i = 1; i < argc; i++)
    {
        strings[i - 1] = argv[i];
    }
    addCountries(&countries, strings);
    printCountries(&countries);
    return 0;
}