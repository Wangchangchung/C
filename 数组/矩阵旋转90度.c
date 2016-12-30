#include<stdio.h>


void rotate(int **matrix, int matrixRowSize, int matrixColSize);
void rotate(int **matrix, int matrixRowSize, int matrixColSize)
{
	int row; 
	int col;
	int a[matrixRowSize][matrixColSize] = (*matrix);

	for(row = 0; row < matrixRowSize; row++)
	{
		for(col = 0; col < matrixColSize; col++)
		{
			matrix[col][matrixColSize - row] = a[row][col];
		}
	}
}


 void main(void)
 {
	 int row;
	 int col;

	 int matrix[3][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	 for(row = 0; row < 3; row++)
	 {
		for(col = 0; col < 3; col++)
			printf("%d",matrix[row][col]);
		printf("\n");
	 }
		
	 rotate(&matrix,3, 3);

	 for(row = 0; row < 3; row++)
	 {
		for(col = 0; col < 3; col++)
			printf("%d",matrix[row][col]);
		printf("\n");
	 }
 }


