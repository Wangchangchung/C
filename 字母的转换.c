#include<stdio.h>

void main(void){

	int a[5] ;
	int temp;
	int i;
	int j;

	printf("��������������֣�");
	for(i = 0; i< 5; i++){
		scanf("%d", &a[i]);
	}
	printf("�����");
	for(i = 0; i < 5; i++){
		for(j = i+ 1; j < 5; j++){
			if(a[i] >= a[j]){
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
	}
	for(i = 0; i < 5; i++){
		printf("%d ", a[i]);
	}
}



/*#include<stdio.h>

void main(void){

	char b ;

	printf("������һ����ĸ:");
	scanf("%c", &b);
	if( b <= 122 && b > 90){
		printf("%c", b-32);
	}
	if( b >=65 && b <= 90){
		printf("%c", b+32);
	}
	printf("\n");
}
*/


