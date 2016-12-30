#include<stdio.h>
#include<string.h>
void main(void)
{
	char s[]="abcd01223\0cvb\0\0";
	char q[]="abcd\01223\0cvb\0\0";
	int a='0';                              //遇0则止
	int b='\0';
	char ss[2][8]={"Beijing","nihao"};

	printf("%d %d\n",sizeof(s), strlen(s));//16,9     '0'为字符零AScII为48  \0 才是0  上边的字符串第一个0为字符0
	printf("%d %d\n",sizeof(q), strlen(q));//q[]数组中\012被当成8进制来看，是一个数，所以为14,7
	printf("%d %d\n",a, b);

	printf("%s\n",ss[0]);//输出第一行
	printf("%s\n",ss[1]);//输出第二行
	printf("%c\n",ss[0][3]);//一维的
	printf("%c3\n",ss[1][0]);
	//printf("%s\n",ss[0][3]);错误.不能如愿输出j
	ss[0][7]='8';
	printf("%c\n",ss[1]);//不能如愿输出e
	printf("%s\n",ss[0]);//输出一整串用字符8链接   联系内存映像图
	printf("%s\n",ss[1]);//还是输出nihao 
	printf("%c\n",ss[0][10]);//ss[][] 中先考虑输出字符串还是字符串的其中一个字符
	printf("%c\n",ss[0][11]);//若输出一串字符串则用格式%s s[] 一个[] 其中[]内的数为第几个字符串
                             //若为其中字符串的一个字符用%c 格式 s[][] 具体的在哪列，哪个
	                         //或者直接ss[0][], [] 为从0起第几个，应为多为数组本质是一维的          
}