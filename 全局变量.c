#include<stdio.h>

void fun(a);
void fun(a)
{
	printf("a = %d\n",a);
}

int a = 10;
void main(void)
{
   // int a = 9;  ȫ�ֱ�����ʹ�õ�
	fun(a);
	return 0;

}