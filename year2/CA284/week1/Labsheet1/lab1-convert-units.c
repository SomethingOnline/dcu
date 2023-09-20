/*
Program: lab1-convert-units.c
Author: Jack Egan
Input: An amount of cms
Output: Print converted figure to inches
*/

/* includes */
#include <stdio.h>
#include <stdlib.h> /* a header file with a function we might need */

int main(int argc, char * argv[])
{
    int centimeters = atoi(argv[1]);
    float inches = 0.0;
    // scanf("%d", &centimeters);

    inches = centimeters / 2.54;
    printf("%.2f\n", inches);

   return(0);

}