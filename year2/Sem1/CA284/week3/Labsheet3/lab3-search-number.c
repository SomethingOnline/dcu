#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char*argv[])
{
    int searchNum = atoi(argv[1]);
    int length = argc - 2;
    int arrayList[50];
    int ans = 0;

    for (int i = 0; i < length; ++i)
    {
        arrayList[i] = atoi(argv[2 + i]);
    }

    for (int i = 0; i < length; ++i)
    {
        if (arrayList[i] == searchNum)
        {
          printf("Found %d at %d\n", arrayList[i], i);
          ans += 1;
          exit(0);
        }
    }
    if (ans == 0)
    {
        printf("%d not found", searchNum);
    }
}
