#include<stdio.h>

struct Student{
	char  name[20];
	int age ;
	int score;
}Student[5];

void main(void)
{
	int i;
	int j;
	struct Student temp;
	printf("请输入五位学生的信息：\n");

	for(i = 0; i < 5 ; i++){
		printf("请输入第%d位学生的成绩：",i+1);
		scanf("%s %d %d",&Student[i].name, &Student[i].age, &Student[i].score);
	}

	printf("排序后：");
	for(i = 0; i < 5 ; i++){
		for(j = i+1; j < 5; j++){
			if(Student[i].score < Student[j].score)
			{
				temp = Student[i];
				Student[i] = Student[j];
				Student[j] = temp;
			}
		}
	}
	for(i = 0; i < 5; i++)
	{
		printf("%s %d %d \n",Student[i].name,Student[i].age, Student[i].score);
	}
}