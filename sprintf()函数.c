#include<stdio.h>
void main(void)
{
	char st[80]	;
	int n = 255;
	char s[23] = "hello";
	char a[12] ="world";
	char q[12] = "I love you";

	sprintf(st,"%d",n);
	printf("%s\n",st);
	//输出 255 此时为字符串

	sprintf(st,"%x",n);
	printf("%s\n",st);
	//将覆盖前一次的对st的赋值， 输出为十六进制的一串字符串ff

	sprintf(st,"%o",n);//变成8进制
	printf("%s\n",st);

	sprintf(st,"%s%s %s",s,a,q);
	printf("%s\n",st);
	/*2、
	sprintf函数    包含在stdio.h 文件中

　　sprintf函数原型为 int sprintf(char *str, const char *format, ...)。作用是格式化字符串，具体功能如下所示：

（1）将数字变量转换为字符串。

（2）得到整型变量的16进制和8进制字符串。

（3）连接多个字符串。*/
}