#include <stdio.h>
#include <stdlib.h>

int main(int argc, char*argv[])
{ 
    int dayCode;
    dayCode = atoi(argv[1]);

    switch(dayCode)
    {
    	case 1:
    		printf("Sunday\n");
    		break;
    	case 2:
    		printf("Monday\n");
    		break;
    	case 3:
    		printf("Tuesday\n");
    		break;
    	case 4:
    		printf("Wednesday\n");
    		break;
        case 5:
    		printf("Thursday\n");
    		break;
        case 6:
    		printf("Friday\n");
    		break;
        case 7:
    		printf("Saturday\n");
    		break;
    }
    return 0;
}