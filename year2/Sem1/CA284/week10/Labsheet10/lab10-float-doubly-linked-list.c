#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;
struct Node{
    float value;
    Node *next;
    Node *prev;
};

Node* get_integers(int n, char *argv[]);
void printIntegersReverse(Node* last);
int main(int argc, char *argv[])
{
    int n = atoi(argv[1]);
    Node *start = NULL;
    start = get_integers(n, argv);
    printIntegersReverse(start);
    return 0;
}


Node* get_integers(int n, char *argv[])
{
    int i = 0;
    Node *prev, *current, *first;

    first = (Node*)calloc(1, sizeof(Node));

    current = first;
    current->value = atof(argv[2]);
    current->prev = NULL;

    while ((i + 1) < n)
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        prev = current;
        current = current->next;
        current->value = atoi(argv[3 + i]);
        current->prev = prev;

        ++i;
    }
    current->next = NULL;
    return current;
}

void printIntegersReverse(Node* last)
{
    Node *p = NULL;
    for (p = last; p != NULL; p = p->prev)
    {
        printf("%.2f\n", p->value);
    }
}