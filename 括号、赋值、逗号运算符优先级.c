#include<stdio.h>
void main(void)
{
	int i, j;
	i = 3, 4*5, 4+5;	//运算的优先级，赋值运算比逗号运算符高；
	j = (3, 4*5, 4+5);		//括号运算符比赋值运算符高，
	printf("%d %d\n",i, j);	
}