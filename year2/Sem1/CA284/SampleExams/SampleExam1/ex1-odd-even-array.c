#include <stdio.h>
#include <stdlib.h>
#include <string.h>



int main(int argc, char* argv[])
{
    int sum = 0;
    int length = argc - 1;
    int nums[length];
    int oddTotal = 0;
    int evenTotal = 0;
    int firstEven = 0;
    // even loop
    for (int i = 1; i < length; ++i)
    {
        if (atoi(argv[i]) % 2 == 0)
        {
            firstEven = atoi(argv[i]);
            break;
        }
    }

    for (int i = 1; i < length; ++i)
    {
        nums[i] = atoi(argv[i]);
        if (atoi(argv[i]) % 2 != 0)
        {
            oddTotal += atoi(argv[i]);
        } 
        else if ((atoi(argv[i]) != firstEven) && (atoi(argv[i])))
        {
            evenTotal += atoi(argv[i]);
        }
        // else if ((evenTotal == 0))
        // {
        //     printf("%d", oddTotal);
        //     printf("%d", evenTotal);
        //     exit(0);
        // }       
        // else if ((oddTotal == 0))
        // {
        //     printf("%d", evenTotal);
        //     printf("%d", oddTotal);
        //     exit(0);
        // }
    }
    
    int evenPrint = firstEven - evenTotal;

    if (length < 2)
    {
        printf("%d\n", atoi(argv[1]));
        printf("0\n");
    }
    else
    {
    printf("%d\n", oddTotal);
    // printf("%d\n", firstEven);
    // printf("%d\n", evenTotal);
    printf("%d\n", evenPrint);
    }
}