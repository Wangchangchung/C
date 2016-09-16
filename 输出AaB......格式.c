#include<stdio.h>
void main(void)
{
	int i;
	for(i = 0; i <1000; i++)
		printf("%c\n",'A' + i%52/2 + i%2*32);
}