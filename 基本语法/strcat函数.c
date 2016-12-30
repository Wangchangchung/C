#include<stdio.h>
#include<string.h>
void main(void)
{
	char a[6] = "abc";
	printf("%s\n",strcat(a,"$"));
	//string.h中的函数多是处理字符数组的，因此不能'$',且牢记不能
	//strcat(“azx”,"asdf") 因为字符串的本质是字符常量，常量不能赋值
}
