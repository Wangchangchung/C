
#include<stdio.h>
void main(void)
{
	char s[80] = "abcdefghij", *p;
	int *q;
	
	p = &s[2];
	//printf("%c\n",*p);   c
	q = (int *)p;
	printf("%c\n",*q);  // c
	printf("%c\n",*((int *)p+1));	//g  强制类型转换p改为指向4字节的int 元素，加一 将移动4 字节
	q++;
//	printf("%c\n",*q);  g

	p = (char *)q;

	printf("%c %s\n",*p,p);		//g ghijs
}