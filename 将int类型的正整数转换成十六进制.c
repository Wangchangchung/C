#include<stdio.h>
#include<string.h>

void fun(int);
char * Sun(int);

char* Sun(int n)
{
	static char res[80] ;
	//char s[80] = {0};
	int i;
	char *p;

	for(i = 0; n ; n/=16, i++)
	
		if(n%16 <10)
			res[80-i-1] = '0' + n%16;
		else
			res[80-i-1] ='A' + n%16 -10;
	
	p=strrev(res);
	//return 
	printf("%s\n",p);
}

void fun(int a)
{
	static char res[80] ; //定义成静态的，在函数调用后不会释放空间
	char s[80] = {0};
	int i;

	for(i = 1; a; a/=16,i++)
		s[80-i-1] = "0123456789ABCDEF"[a%16];//注意这个形式
	strcpy(res ,s+(80-i));
	printf("%s\n",res);
	//return res;
}

void main(void)
{
	int a;
	printf("请输入一个数：");
	scanf("%d",&a);

	fun(a);
	Sun(a);

}