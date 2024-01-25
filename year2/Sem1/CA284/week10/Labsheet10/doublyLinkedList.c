#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;
struct Node {
    int value;
    Node *next;
    Node *prev;
};
Node* get_attributes(int n, char*argv[]);
void printIntegers(Node* start);

int main(int argc, char *argv[])
{
    int n = atoi(argv[1]);
    Node *start = NULL;
    start = get_attributes(n, argv);
    printIntegers(start);
    return 0;
}

Node* get_attributes(int n, char*argv[])
{
    Node *current, *first, *prev;
    first = (Node*)calloc(1, sizeof(Node));
    current = first;
    current->value = atoi(argv[2]);
    current->prev = NULL;
    for (int i = 1; i < n; ++i)
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        prev = current;
        current = current->next;
        current->prev = prev;
        current->value = atoi(argv[i + 2]);
    }
    current->next = NULL;
    return first;
}

void printIntegers(Node* start)
{
    Node *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        printf("%d\n", p->value);
    }
}
