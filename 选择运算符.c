#include<stdio.h>

void main(void)
{
	int a;
	int b;
	int c;
	printf("����������������\n");
	scanf("%d %d %d", &a, &b, &c);

	printf("��������������Ϊ��%d\n",(a>b ? a:b)> c ?(a>b ? a:b):c);
}
