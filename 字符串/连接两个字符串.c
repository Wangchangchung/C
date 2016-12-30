#include<stdio.h>
void main(void)
{
	char array[2][8] = {"beijing","xi'an"};
	array[0][7] = '2';
	puts((char *)array);//更改了字符串的0结束标志
	//原来的array的类型为char[8],强制类型转换成char* ,因为puts 函数接收的参数为char * 类型的
}
