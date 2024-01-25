#include <stdio.h>
#include <stdlib.h>
#include <string.h>

float ProdNum(float num1, float num2);
float DivNum(float num1, float num2);

int main(int argc, char*argv[])
{
    float num1, num2, sum;

    char myOperation[10];

    strcpy(myOperation, argv[1]);

    num1 = atof(argv[2]);
    num2 = atof(argv[3]);

    if (strcmp(myOperation, "multiply") == 0)
    {
        sum = ProdNum(num1, num2);
        printf("%f\n", sum);
    }
    else if (strcmp(myOperation, "divide") == 0)
    {
        if (num2 != 0)
        {
            sum = DivNum(num1, num2);
            printf("%f\n", sum);
        }
        else 
        {
            printf("invalid\n");
        }
    }
}


float ProdNum(float num1, float num2)
{
    float answer;
    answer = num1 * num2;
    return answer;
}

float DivNum(float num1, float num2)
{
    float answer;
    answer = num1 / num2;
    return answer;
}