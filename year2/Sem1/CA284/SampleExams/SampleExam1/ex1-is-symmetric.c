#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char* argv[])
{
    char myString[100];
    strcpy(myString, argv[1]);
    // printf("%s\n", myString);
    int length = strlen(myString);
    // printf("Length %d\n", length);
    // printf("String %s\n", myString);
    int yes = 0;

    char myNewString[100];
    for (int i = 0; i < length; ++i)
    {
        if (myString[i] != ' ')
        {
            myNewString[i - 1] = myString[i];
        }
    }

    for (int i = 0; i < length; ++i)
    {
        printf("%c\n", myNewString[i]);
    }
    int myNewLen = strlen(myNewString);
    for (int i = 0; i < myNewLen / 2; ++i)
    {
        printf("normal %c\n", myNewString[i]);
        printf("Reversed %c\n", myNewString[myNewLen - 1 - i]);
        if (myNewString[i] == myNewString[myNewLen - 1 - i])
        {
            printf("Yep works for these 2 Normal %c & Reverse %c\n", myNewString[i], myNewString[myNewLen - i - 1]);
            yes += 1;
        }
    }

    if (yes == (myNewLen - 1))
    {
        printf("yes");
    }
    else
    {
        printf("no");
    }
    printf("%d", yes);

}