#include<stdio.h>
#include<string.h>

void main(void)
{
	char  c[80] ="xyz";
	char  ch[] = "pipii";
	printf("%d\n",sizeof(c));
	printf("%d\n",strlen(c));
	printf("%d\n",sizeof(ch));
	printf("%d\n",strlen(ch));
}