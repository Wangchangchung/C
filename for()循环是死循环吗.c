#include<stdio.h>
void main(void)
{
	int i;
	for(i = 1; i > 0; i++)
		printf("%d ",i);	 //不是死循环，最后会变成负数
}
