#include <stdio.h>

int main(int argc, char*argv[])
{
    int answer;
    int var1 = 15000;
    int var2 = 15000;
    answer = var1 + var2;
    printf(answer);
    var1 += 2000;
    var2 += 2000;
}