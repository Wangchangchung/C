#include<stdio.h>
void main(void)
{
	int i;
	printf("«Î ‰»Îiµƒ÷µ£®1£¨ 2£¨ 3£©:");
	scanf("%d",&i);

	switch(i)
	{
		case 1:
			printf("I'am case1\n");
			break;
		default:
			printf("I'am default\n");
		case 2:
			printf("I'am case2\n");
	}
}