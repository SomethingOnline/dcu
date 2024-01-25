#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;

struct Node{
    int value;
    Node *prev;
    Node *next;
};

Node* get_integers(int n, char *argv[]);
void printIntegers(Node* start);
Node* pop(Node* start);
Node* push(Node *start, int num);

int main(int argc, char *argv[])
{
    int n = atoi(argv[1]);
    Node *start = NULL;
    start = get_integers(n, argv);
    pop(start);
    pop(start);
    push(start, atoi(argv[n + 2]));
    push(start, atoi(argv[n + 3]));
    printIntegers(start);
}

Node* get_integers(int n, char *argv[])
{
    int i = 0;
    Node *prev, *current, *first;

    first = (Node*)calloc(1, sizeof(Node));
    current = first;
    current->value = atoi(argv[2]);
    current->prev = NULL;

    while ((i + 1) < n)
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        prev = current;
        current = current->next;
        current->value = atoi(argv[i + 3]);
        current->prev = prev;
        ++i;
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

Node* pop(Node *start)
{
    Node *p = NULL;
    Node *temp = NULL;
    for (p = start; p != NULL; p = temp)
    {
        temp = p->next;
        if (temp == NULL)
        {
            p->prev->next = NULL;
            free(p);
        }
    }

}

Node* push(Node *start, int num)
{
    Node *p = NULL;
    Node *temp = NULL;
    Node *newNode = (Node*)calloc(1, sizeof(Node));

    newNode->value = num;
    newNode->next = NULL;
    for (p = start; p != NULL; p = temp)
    {
        temp = p->next;
        if (temp == NULL)
        {
            newNode->prev = p;
            p->next = newNode;
        }
        
    }
    return start;
}
