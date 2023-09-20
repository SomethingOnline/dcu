/*
Program: lab1-rugby.c
Author: Jack Egan
Input: (try, conversion, penalty, drop-goal)
Output: Total points
*/

/* includes */
#include <stdio.h>
#include <stdlib.h> /* a header file with a function we might need */

int main(int argc, char * argv[])
{
    int try = atoi(argv[1]) * 5;
    int conversion = atoi(argv[2]) * 2;
    int penalty = atoi(argv[3]) * 3;
    int dropGoal = atoi(argv[4]) * 3;

    int sum = try + conversion + penalty + dropGoal;
    printf("%d\n", sum);


    return (0);

}