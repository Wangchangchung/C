#include<stdio.h>


void main(void)
{
	char *str1 = "Welcometo\0Xiyoulinux\n";
	char str2[] = "Welcometo\0Xiyoulinux\n";
	printf(" %d\n",printf("%s",str1));
	printf("%d,%d\n",strlen(str1), strlen(str2));
	printf("%d,%d\n",sizeof(str1), sizeof(str2));
}