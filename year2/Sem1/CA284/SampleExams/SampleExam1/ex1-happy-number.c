#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int is_happy(int num);

int main(int argc, char* argv[])
{
    int n = atoi(argv[1]);
    int result = is_happy(n);
    if (result == 1)
    {
        printf("is happy\n");
    }
    else
    {
        printf("not happy\n");
    }
}


int is_happy(int num)
{
    int iteration = 0;
    while (iteration < 3)
    {
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;
        int sum = 0;
        digit1 = (num / 100);
        digit1 = digit1 * digit1;
        printf("%d\n", digit1);
        digit2 = ((num % 100) / 10);
        digit2 = digit2 * digit2;
        printf("%d\n", digit2);
        digit3 = ((num % 100) % 10);
        digit3 = digit3 * digit3;
        printf("%d\n", digit3);
        sum = digit1 + digit2 + digit3;
        num = sum;
        printf("This is the total %d\n", num);
        if ((num / 100) == 1)
        {
            return 1;
        }
        iteration += 1;

    }
}




// #include<stdio.h>
// #include<stdlib.h>
// #include <string.h>

// int main(int argc, char*argv[])
// {
//     int num = atoi(argv[1]);
//     int sum;
//     int num1;
//     int num2;
//     int num3;

//     if(num < 10){
//         printf("Not happy\n");
//         return 0;
//     }

//     for(int i = 0; i != num ;++i ){
//         if (num < 99){
//             num1 = num % 10;
//             num2 = num / 10;
//             sum = (num1 * num1) + (num2 * num2);
//         }else{
//             num1 = num / 100;
//             num2 = (num % 100) / 10;
//             num3 = (num % 100) % 10;

//             sum = (num1 * num1) + (num2 * num2) + (num3 * 2);
//         }


//         if(sum == 1){
//             printf("Is happy\n");
//             return 1;

//         }
//         num = sum;

//     }
//     printf("Not happy\n");
//     return 0;
// }