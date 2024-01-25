#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;
struct Node {
    int value;
    Node *next;
};

Node* get_integers(int n, char *argv[]);
void printIntegers(Node *start);

int main(int argc, char *argv[])
{
    int n = atoi(argv[1]);
    Node *start = NULL;
    start = get_integers(n, argv);
    printIntegers(start);
    return 0;
}

Node* get_integers(int n, char *argv[])
{
    int i = 0;
    Node *current, *first;

    first = (Node*)calloc(1, sizeof(Node));
    current = first;
    current->value = atoi(argv[2]);

    while ((i + 1) < (n))
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        current = current->next;
        current->value = atoi(argv[3 + i]);
        ++i;
    }
    current->next = NULL;
    return first;
}

void printIntegers(Node *start)
{
    Node *p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        printf("%d\n", p->value);
    }
}