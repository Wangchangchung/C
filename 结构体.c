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
	printf("��������λѧ������Ϣ��\n");

	for(i = 0; i < 5 ; i++){
		printf("�������%dλѧ���ĳɼ���",i+1);
		scanf("%s %d %d",&Student[i].name, &Student[i].age, &Student[i].score);
	}

	printf("�����");
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