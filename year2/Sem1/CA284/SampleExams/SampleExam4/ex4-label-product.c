#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Product Product;
struct Product{
    char* itemcode;
    int price;
    int numsold;
    int status;
    Product *next;
};

Product* populateLinkedList(int *n, char* argv[]);
void printList(Product* start);
void calAverage(Product* start, int *average, int *n);
void getStatus(Product* start, int* average);
void matchCountries(Product* start);
void freeList(Product* start);
int main(int argc, char*argv[])
{
    int n = (argc - 1) / 3;
    int average = 0;
    Product *start = NULL;
    start = populateLinkedList(&n, argv);
    calAverage(start, &average, &n);
    matchCountries(start);
    getStatus(start, &average);
    printList(start);
    // Free allocated memory
    freeList(start);
    return 0;

}
Product* populateLinkedList(int *n, char* argv[])
{
    Product *current, *first;
    first = (Product*)calloc(1, sizeof(Product));
    if (!first) 
    {
        printf("Allocation failed");
        return 0;
    }
    current = first;
    current->itemcode = (char*)malloc(strlen(argv[1]) + 1);
    if (!current->itemcode) 
    {
        printf("Allocation failed");
        return 0;
    }
    strcpy(current->itemcode, argv[1]);
    current->price = atoi(argv[2]);
    current->numsold = atoi(argv[3]);
    int index = 4;
    for (int i = 1; i < *n; ++i)
    {
        current->next = (Product*)calloc(1, sizeof(Product));
        if (!current->next) 
        {
            printf("Allocation failed");
            return 0;
        }
        current = current->next;
        current->itemcode = (char*)malloc(strlen(argv[index]) + 1);
        if (!current->itemcode) 
        {
            printf("Allocation failed");
            return 0;
        }
        strcpy(current->itemcode, argv[index]);
        current->price = atoi(argv[index + 1]);
        current->numsold = atoi(argv[index + 2]);
        index += 3;
    }
    current->next = NULL;
    return first;
}


void printList(Product* start)
{
    Product *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        printf("%d\n", p->status);
        printf("%s\n", p->itemcode);
    }
}

void calAverage(Product* start, int *average, int *n)
{
    Product *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        *average += (p->price * p->numsold);
    }
    *average = *average / *n;
}
void matchCountries(Product* start)
{    
    Product *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        if (strncmp(p->itemcode, "IE", 2) == 0)
        {
            strcpy(p->itemcode, "Ireland");
        }
        else if (strncmp(p->itemcode, "SP", 2) == 0) 
        {
            strcpy(p->itemcode, "Spain");
        } 
        else if (strncmp(p->itemcode, "FR", 2) == 0) 
        {
            strcpy(p->itemcode, "France");
        } 
        else if (strncmp(p->itemcode, "US", 2) == 0) 
        {
            strcpy(p->itemcode, "USA");
        } 
        else if (strncmp(p->itemcode, "RU", 2) == 0) 
        {
            strcpy(p->itemcode, "Russia");
        }
    
    }
}

void getStatus(Product* start,int* average)
{
    Product *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        p->status = 0;
        if (((p->price) * (p->numsold)) >= *average)
        {
            p->status = 1;
        }
    }
}
void freeList(Product* start) {
    Product* current = start;
    while (current != NULL) {
        Product* next = current->next;
        free(current->itemcode);
        free(current);
        current = next;
    }
}