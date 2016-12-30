#include<stdio.h>
#include<malloc.h>
#include"Point.h"
/*
1 2
3 4
6 7
8 9
6 4
3 1
9 0
*/
void initPoint( POINT **h );
void Showpoints(POINT *h);
void Destorylink(POINT **h);
void setPoint(POINT *N, int row, int col);
void insertPoint(POINT **h);
POINT *LocatPoint(POINT *h, int lrow, int lcol);
void Delectpoint(POINT **h);
void SortPointsByrowU(POINT *);//链表的排序，按行值的升序（up）来排列

void SortPointsByrowU(POINT *h)
{
	POINT *p = NULL;
	POINT *q = NULL;
	POINT t ;
	POINT *f;
	printf("\n				现在进行排序操作\n");
	for(p = h; p; p = p->next)
		for(q = p->next; q; q = q->next)
		{
			if(p->row > q->row )
			{
				t = *q;
				*q =*p;	//先整体交换一个节点，因为考虑到有多个成员；整体交换更好
				*p = t;

				f = q -> next;
				q->next = p->next;		//交换的同时也交换了链域，如果不交换回来则会乱指出错，
				p -> next= f;		//所以只要交换会链域值即可，注意这种技巧

			}
		}
}

void Delectpoint(POINT **h)
{
	int row;
	int col;
	POINT *p;
	POINT *q;

	printf("			\n下面进行节点删除\n");
	printf("请输入要删除的节点如（3 4）：");
	scanf("%d%d",&row , &col);
	p = LocatPoint(*h, row, col);
	
	if(p == NULL)
	{
		 p =  *h;
		*h = (*h)->next;
		free(p);
	}
	else if(p->next == NULL)
		printf("删除的点不存在，删除失败！");
	else
	{
		q = p->next ;
		p ->next = q->next;//p = q->next
		free(q);
	}
	//q = p->next;
	//p =p->next ->next;
	//Showpoints(*h);可在函数中调用或者在主函数中调用

}


POINT *LocatPoint(POINT *h, int lrow, int lcol)
{
	POINT *q = NULL;
	POINT *p = NULL;
	

	for( p= h; p &&( p->row != lrow || p->col != lcol); p = p->next)
		q = p;    //定位要查找的点的实质是找前驱结点的地址 
	return q;
}

void insertPoint(POINT **h)
{
	int row, lrow;
	int col, lcol;
	POINT *p;
	POINT *q;


	//输入新点坐标
	printf("请输入新点坐标如（3 5）：");
	scanf("%d%d",&row, &col);
	p = (POINT *)malloc(sizeof(POINT));
	setPoint(p, row, col);

	printf("请输入要插入点坐标如（3 5）：");
	scanf("%d%d",&lrow, &lcol);

	//定位要插入的点坐标
	q = LocatPoint(*h, lrow, lcol);
	
	if(q == NULL)  //当要插入点为第一个点前面时
	{
		//*h=p;
		p->next = *h;
		*h = p;
	}
	else if(q->next == NULL)   //当没有找到时 ，链入链表的末尾，
	{
		q->next = p;
	}
	else                  //除上面两种情况外的 一般正常情况
	{
		p->next = q->next ;
		q->next = p;

	}
	//Showpoints(*h); 可以在函数中显示出，也可以在主函数中显示

}

void setPoint(POINT *N, int row, int col)
{
	N->row = row;
	N->col = col;
	N->next = NULL;	
}


void Destorylink(POINT **h)
{
	POINT *p;

	while(*h /* 或者是p->next */)
	{
		p = *h;
		*h = p->next;//这样也行 *h = (*h)->next;
		free(p);
	}
}

void Showpoints(POINT *h)
{
//	int row;
//	int col;
	POINT *p;

	//显示点坐标
	printf("			\n你输入的点坐标是：\n");
	for(p = h; p ; p = p-> next)
		printf("(%d %d)  ", p->row, p->col);
	printf("\n");
}

void initPoint( POINT **h)
{
	int row;
	int col;
	POINT *p;
	POINT *q;

	//提示输入节点
	printf("请输入坐标点（例如 4 5），若任一坐标中有0,则结束输入：");
	scanf("%d%d",&row, &col);
	while(row != 0 && col != 0)
	{
		p = (POINT *)malloc(sizeof(POINT));
		setPoint(p, row, col);			//	p->col = col;
										//	p->row = row;
										//	p->next = NULL;

		if(*h ==NULL)  //处理第一个节点
			*h = p;	   
		else
		{
			q -> next =p;//将除第一个点外，之后的点链入链表中（更改上个点链域的值，赋值为下个节点的地址）
		}
		q = p;//保留上个节点的值域和链域，主要是保留链域值

		printf("请输入坐标点（例如 4 5），若任一坐标中有0,则结束输入：");
		scanf("%d%d",&row, &col);
	}
	//申请空间
	//处理点
}

void main(void)
{
	/*typedef struct POINT
	{
		int col;
		int row;
		struct POINT *next;

	}POINT;*/

	POINT * link1 = NULL;
	POINT * link2 = NULL;

	initPoint(&link1);

	Showpoints(link1);

	//Destorylink(&link1);最后再来销毁

	insertPoint(&link1);
	Showpoints(link1);

	Delectpoint(&link1);
	Showpoints(link1);

	SortPointsByrowU(link1);
	Showpoints(link1);

}