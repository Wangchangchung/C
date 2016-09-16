#include<stdio.h>

void Show(char * );  
                            //void Show(char st[10])
void Show(char *st)         //形式参数要与声明的类型一致
{
	printf("在子函数中,sizeof(st)=%d\n",sizeof(st));
}

void main (void)
{
	char st[10]={1, 2, 3, 4, 5, 5, 5, 5, 5, 6};
	//char *p;
	
	printf("在主函数中，sizeof(st)=%d\n",sizeof(st));
	Show(st);

}