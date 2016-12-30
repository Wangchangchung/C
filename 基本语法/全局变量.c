#include<stdio.h>

void fun(a);
void fun(a)
{
	printf("a = %d\n",a);
}

int a = 10;
void main(void)
{
   // int a = 9;  全局变量的使用的
	fun(a);
	return 0;

}