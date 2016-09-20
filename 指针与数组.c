#include<stdio.h>
void main(void)
{
	int *p, i, *star, *end, t;
	int st[20]={1, 2, 3, 4, 5, 6, 7};
	int a, s[20], s1[20];
	char cont;

	p=&a;              // 左右指类要相同 
	*p=3;
	printf("%d\n",a);  //可以说st 指向了st[0]
	*(st+7)=4;        //数组名称为数组地址，*(st+0)=1 => st[0]=1  *(st+2)=4 => st[2]=4
	printf("%d\n",st[7]);
            //         A[i] = *(A+i)
	        // a[i] <=>*（a+i）<=> *(i+a) <=> i[a]
	printf("请输入你想要的数组个数：");
	scanf("%d",&cont);
	printf("请输入数组：");
	for(p=s; p<s+cont;  p++)
		scanf("%d",p);//  p=&s[0] =>  p= &*(s+0) => p=s
	for(p=s; p-s<cont; p++) //p=&s[1] => p=&*(s+1) => p=s+1
		printf("%d ",p[0]);//p+i = s+i
	
	printf("\n");
	printf("请输入数组(20个数以内)：");
	for(i=0, p=s1; i<4; i++)
		scanf("%d",p+i);
	for(i=0; i<4; i++)
		printf("%d ",s1[i]);
	printf("\n");
	printf("按逆序输出\n");
	for(star=st,end=st+7; star<end; star++,end--)//star-end 等于数组下标之差  注意end=st+7 这个式子的意义
	{
		 t=*star;       //t=star[0];            t=star[0];
		*star=*end;     //star[0]=end[0];       *star=end[0];
		*end=t;         //end[0]=t;             *end=t;
	}
	for(p=st;p<st+8;p++) // p<st+8 => p-st<8   数组下标之差
	{
		printf("%d",*p);
		//printf("%d",p[0]);
	}
	printf("\n");
}