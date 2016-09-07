#include<stdio.h>

void main(void)
{
	int a;
	int b;
	int c;
	printf("请输入三个整数：\n");
	scanf("%d %d %d", &a, &b, &c);

	printf("三个数中最大的数为：%d\n",(a>b ? a:b)> c ?(a>b ? a:b):c);
}
