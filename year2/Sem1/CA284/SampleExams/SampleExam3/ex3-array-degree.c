#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct Node Node;
struct Node {
    int value;
    Node *next;
    Node *prev;
};

Node* add_to_list(char *argv[], int *argc);
void find_degree(Node* start, int *degree);
int main(int argc, char *argv[])
{
    Node *start = NULL;
    int degree = 0;
    start = add_to_list(argv, &argc);
    find_degree(start, &degree);
    printf("%d\n", degree);

    Node* current = start;
    Node* next;
    while (current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }
    return 0;
}
Node* add_to_list(char *argv[], int *argc)
{
    Node *current, *first, *prev;
    first = (Node*)calloc(1, sizeof(Node));
    if (!first) 
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }
    current = first;
    current->value = atoi(argv[1]);
    current->prev = NULL;
    for (int i = 2; i < *argc; ++i)
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
        current->value = atoi(argv[i]);
    }
    current->next = NULL;
    return first;
}

void find_degree(Node* start, int *degree)
{
    Node *p = NULL;
    Node *j = NULL;
    int maxCount = 0;
    for (p = start; p != NULL; p = p->next)
    {
        int temp = p->value;
        int count = 1;
        for (j = p->next; j != NULL; j = j->next)
        {
            if (j->value == temp)
            {
                count += 1;
            }
        }
        if (count > maxCount)
        {
            maxCount = count;
        }
    }
    *degree = maxCount;
}