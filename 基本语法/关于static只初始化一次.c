#include<stdio.h>

int *fun(void);
int *fun(void)
{
	static int a = 1;
	a++;
	return &a;
}

void main(void)
{
	int *b;
	b = fun();
	printf("%d\n",*b);
	b = fun();
	printf("%d\n",*b);
	return 0;

}