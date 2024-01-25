#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node Node;
struct Node 
{
    char* code;
    char* origin;
    int price;
    Node* next;
    Node* prev;
};

Node* add_to_list(char* argv[], int* n);
void print_list(Node* start);
Node* edit_Ireland(Node* start);

int main(int argc, char* argv[]) 
{
    Node* start = NULL;
    int n = (argc - 1) / 3;
    start = add_to_list(argv, &n);
    edit_Ireland(start);
    print_list(start);

    // Free the allocated memory
    Node* p = NULL;
    Node* nextNode = NULL;
    for (p = start; p != NULL; p = nextNode) 
    {
        nextNode = p->next;
        free(p->code);
        free(p->origin);
        free(p);
    }

    return 0;
}

Node* add_to_list(char* argv[], int* n) 
{
    Node* current, *first, *prev;

    first = (Node*)calloc(1, sizeof(Node));
    if (!first) 
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }
    current = first;
    current->code = strdup(argv[1]);
    current->origin = strdup(argv[2]);
    current->price = atoi(argv[3]);
    current->prev = NULL;

    int index = 3;
    for (int i = 1; i < *n; ++i) 
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        if (!current->next) 
        {
            printf("Memory allocation failed, exiting...\n");
            exit(0);
        }
        prev = current;
        current = current->next;
        current->prev = prev;
        current->code = strdup(argv[index + 1]);
        current->origin = strdup(argv[index + 2]);
        current->price = atoi(argv[index + 3]);

        index += 3;
    }
    current->next = NULL;
    return first;
}

void print_list(Node* start) 
{
    Node* p = NULL;
    for (p = start; p != NULL; p = p->next) 
    {
        printf("%s\n", p->code);
        printf("%s\n", p->origin);
        printf("%d\n", p->price);
    }
}

Node* edit_Ireland(Node* start) 
{
    Node* p = NULL;
    for (p = start; p != NULL; p = p->next) 
    {
        if (strcmp(p->origin, "Ireland") == 0) 
        {
            p->price = p->price + (p->price * 0.20);
        }
    }
}