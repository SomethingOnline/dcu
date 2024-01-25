#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

float sum(float, float);
float difference(float, float);
float product(float, float);
float division(float, float);
float power(float, float);
float natural_log(float, float);

struct Operation{
    float (*operation)(float, float);
};

int main(int argc, char*argv[])
{
    float a = atof(argv[1]);
    float b = atof(argv[2]);
    struct Operation ops[6] = {sum, difference, product, division, power, natural_log};
    for (int i = 0; i < 6; ++i)
    {
        float answer = ops[i].operation(a, b);
        printf("%.2f\n", answer);
    }
    return 0;  
}



float sum(float a, float b)
{
    return a + b;
}
float difference(float a, float b)
{
    return a - b;
}
float product(float a, float b)
{
    return a * b;
}
float division(float a, float b)
{
    return a / b;
}
float power(float a, float b)
{
    return powf(a, b);
}
float natural_log(float a, float b)
{
    return logf(a) + logf(b);
}