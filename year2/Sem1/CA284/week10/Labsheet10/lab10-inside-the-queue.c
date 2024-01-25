#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;
struct Node{
    int value;
    Node* prev;
    Node* next;
};

Node* get_integers(int *array);
Node* add_e(Node* start, int value, int element);

void printIntegers(Node* start);

int main(int argc, char *argv[])
{
    int array[10] = {8, 7, 3, 4, 5, 6, 9, 2, 14, 12};
    Node* start = NULL;
    start = get_integers(array);
    add_e(start, atoi(argv[1]), atoi(argv[2]));
    printIntegers(start);
}

Node* get_integers(int *array)
{
    Node *current, *prev, *first;

    first = (Node*)calloc(1, sizeof(Node));
    current = first;
    current->value = array[0];
    current->prev = NULL;

    for (int i = 1; i < 10; ++i)
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        prev = current;
        current = current->next;
        current->value = array[i];
        current->prev = prev;
    }
    current->next = NULL;
    return first;
}
Node* add_e(Node *start, int value, int element)
{
    Node *p = NULL;
    Node *current, *prev, *newNode;
    int count = 0;
    for (p = start; p != NULL; p = p->next)
    {
        if (p->value == value)
        {
            newNode = (Node*)calloc(1, sizeof(Node));
            newNode->value = element;
            newNode->prev = p;
            newNode->next = p->next;
            if (p->next != NULL)
            {
                p->next->prev = newNode;
            }
            p->next = newNode;
        }
    }
    return start;

}
void printIntegers(Node* start)
{
    int count = 0;
    Node *p = NULL;
    for (p = start; p!= NULL; p = p->next)
    {
        count++;
        printf("%d\n", p->value);
    }
}

