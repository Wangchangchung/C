#include<stdio.h>
typedef struct MY_TYPE
{
	int a;
	char *b[4];
	double c;

}MT;

typedef union YOUR_TYPE
{
	int a;
	char *b[4];
	double c;

}YT;

void main(void)
{
	MT q;
	YT k;

	printf("%d %d %d\n",sizeof(int),sizeof(MT),sizeof(YT));
	printf("%p %p %p %p %p %p\n",&q.a, &q.b[0], &q.b[1], &q.b[2], &q.b[3], &q.c);
	printf("%p %p %p %p %p %p\n",&k.a, &k.b[0], &k.b[1], &k.b[2], &k.b[3], &k.c);
}