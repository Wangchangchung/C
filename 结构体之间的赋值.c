#include<stdio.h>
#include<string.h>

struct A
{
	int dateInt;
	char dateChar[20];
};

struct B
{
	//char dateChar[20];
	int dateInt;
	char dateChar[20];

};

void main(void)
{
	struct A a, c;
	struct B b;
	
	a.dateInt = 12;
	strcpy(a.dateChar ,"nihao");

	c=a; 
	//同一结构体的实例可以被直接复制
	//	b=a	     结构体不可以赋值  cannot convert from 'struct A ' to 'struct B
	//	不同结构体的实例之间也不可以直接赋值
	// 即使强制类型转换也不行  b = （struct B） a; 错误
	printf("%d %s\n",c.dateInt,c.dateChar);

}