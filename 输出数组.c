#include<stdio.h>

void main(void)
{
	int arr[5];
	int i;
	int j;
	int temp;

	printf("请输入5个整数：");
	for( i = 0; i < 5; i++){
		scanf("%d",arr + i);  // scanf("%d",&arr[i]);
	}

	for( i = 0; i < 5; i++){
		for(j = i+1; j < 5; j++){
			if(arr[i] > arr[j]){
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	printf("排序后：");

	for(i = 0; i < 5; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");

}