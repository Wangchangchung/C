#include<stdio.h>
void main(void)
{
	char st[80];
	char i;
	printf("请输入一个数组：" );
	scanf("%s",st);
	                          //从键盘输入一串字符串,格式符%s所对应到的表达式
	for(i=0; i<10; i++)      //就目前而言，只能（必须是）字符型数组名称，且不能跟&，数组名称本身是地址
		printf("%c",st[i]);  //这样输入的字符串中，是不能包含空格，TAb字符的（要有空格得用gets()函数）
	printf("\n");  
	                          //若输入为abc<回车>，则st[0]=a, st[1]=b, st[2]=c, st[3]=0
	for(i=0; st[i]; i++)
		printf("%c ",st[i]);  //非0 为真 很好的输出用户输入的值
	printf("\n");             //当先使用scanf(“%s”)接收字符串,且回车后，再使用gets 函数前最好使用flushall()函数
}                            // 清空键盘缓冲区