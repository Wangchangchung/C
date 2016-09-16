#include<stdio.h>
void main(void)
{
	int a[3][4];
	printf("%p %p %p %p %p %p\n", &a[0][0], a[0], a, a[0]+1, a[1]);
	return 0;

}