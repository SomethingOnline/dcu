/*
Program: lab1-hello_again-further.c
Author: Jack Egan
Input: Tai
Output: Print out the given name
*/

/* includes */
#include <stdio.h>
#include <stdlib.h> /* a header file with a function we might need */

int main(int argc, char * argv[])
{
    char myName[100000];
    scanf("%s", myName);
    printf("Hello\n%s\n", myName);
    return (0);
}
