#include<stdio.h>
#include<string.h>

void fun(char *);
void fun (char *a)
{
	printf("%lu\n",sizeof(a));
	printf("%lu\n",strlen(a));
}

void main(void)
{
	char st[] = "hello nihao";

	fun(st);
	printf("%lu\n",sizeof(st));
	printf("%lu\n",strlen(st));
}