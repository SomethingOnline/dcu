#include <stdio.h>
#include <stdlib.h>

typedef struct Node Node;
struct Node
{
    int value;
    Node *next;
    Node *prev;
};

Node *add_nodes(char *argv[], int *length);
Node *addSumToEnd(Node *start, int *sum);
void getSum(Node *start, int *sum);
Node *delEvens(Node *start);
void printList(Node *start);
int main(int argc, char *argv[])
{
    Node *start = NULL;
    int sum = 0;
    int len = argc - 1;
    start = add_nodes(argv, &len);
    start = delEvens(start);
    getSum(start, &sum);
    addSumToEnd(start, &sum);
    printList(start);
    // printf("%d\n", sum);

    // Free allocated memory
    Node *current = start;
    Node *next;
    while (current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }

    return 0;
}

Node *add_nodes(char *argv[], int *length)
{
    Node *first, *current, *prev;

    first = (Node*)calloc(1, sizeof(Node));
    if (!first) 
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }
    current = first;
    current->value = atoi(argv[1]);
    current->prev = NULL;

    for (int i = 1; i < *length; ++i)
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        if (!current->next) 
        {
            printf("Memory allocation failed, exiting...\n");
            exit(0);
        }
        prev = current;
        current = current->next;
        current->value = atoi(argv[i + 1]);
        current->prev = prev;
    }
    current->next = NULL;
    return first;
}

Node *delEvens(Node *start)
{
    Node *nextNode;
    for (Node *p = start; p != NULL; p = nextNode)
    {
        nextNode = p->next;
        if (p->value % 2 == 0)
        {
            if (p->prev != NULL)
                p->prev->next = nextNode;
            if (nextNode != NULL)
                nextNode->prev = p->prev;
            if (p == start)
                start = nextNode;
            free(p);
        }
    }
    return start;
}

void getSum(Node *start, int *sum)
{
    Node *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        *sum += p->value;
    }
}


Node *addSumToEnd(Node *start, int *sum)
{
    Node *newNode = (Node *)calloc(1, sizeof(Node));
    if (!newNode)
    {
        printf("Memory allocation failed, exiting...\n");
        exit(0);
    }

    newNode->value = *sum;
    newNode->next = NULL;

    if (start == NULL)
    {
        // If the list is empty, the new node becomes the start
        start = newNode;
        newNode->prev = NULL;
    }
    else
    {
        // Traverse to the end of the list and add the new node
        Node *p;
        for (p = start; p->next != NULL; p = p->next)
        {}

        p->next = newNode;
        newNode->prev = p;
    }

    return start;
}

void printList(Node *start)
{
    Node *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        printf("%d\n", p->value);
    }
    
}