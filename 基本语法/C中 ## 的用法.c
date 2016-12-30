#include<stdio.h>

#define f(a, b) a##b
#define g(a) #a
#define h(a) g(a)

void main(void)
{
	printf("%s\n",h(f(1, 2)));
	printf("%s\n",g(f(1, 2)));
}