#include<stdio.h>
//#include<stdlib.h>

int strlen(char *string)

{
	int length = 0;

	while( *string ++ != '\0' )
		length += 1;
	return length;
	
}

void main(void)
{
	char q[5]= "abcd";
	int a;
	char s[7] = "aaasdf";
	int b;

	a = strlen("abcd");
	b = strlen(s);
	printf("%d\n", a);
	printf("%d\n", b);
}

