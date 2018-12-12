#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node{
int num;
struct node *next;
struct node *rand;
char ch;
}*start=NULL;

void create(int i){
    struct node *new_node, *temp;
    new_node=(struct node *)malloc(sizeof(struct node));
    new_node->num=i;
    new_node->rand=NULL;
    new_node->next=NULL;
    new_node->ch='\0';
    if(start==NULL)
    {
        start=new_node;
        temp=new_node;
    }
    else
    {
        temp=start;
        while(temp->next!=NULL)
            temp=temp->next;

        temp->next=new_node;
        //printf("%d\n",temp->num);
        temp=new_node;
    }
}

void newGame(){
    int i;
    for(i=1;i<=100;i++)
    {
        create(i);
    }

    /*
    struct node *temp = start;
    while(temp->next!=NULL)
    {
        printf("here : %d\n",temp->num);
        temp=temp->next;
    }
    */

    ladder(19,38);
    ladder(21,82);
    ladder(28,53);
    ladder(36,57);
    ladder(43,77);
    ladder(50,91);
    ladder(54,88);
    ladder(62,96);
    ladder(66,87);
    ladder(80,99);

    snake(98,13);
    snake(95,37);
    snake(92,51);
    snake(83,22);
    snake(69,33);
    snake(68,2);
    snake(64,24);
    snake(59,18);
    snake(52,11);
    snake(48,9);
    snake(46,15);
    snake(44,22);
    snake(38,19);
}

void ladder(int a, int b){
    struct node *beg, *end;
    beg=start;
    end=start;
    while(beg->num!=a)
    {
        beg=beg->next;
    }

    //printf("%d",beg->num);

    while(end->num!=b)
    {
        end=end->next;
    }

    //printf("\t%d\n",end->num);

    beg->rand=end;
    beg->ch='L';

    //printf("%d\n",beg->rand->num);
}

void snake(int a, int b){
    struct node *beg, *end;
    beg=start;
    end=start;

    while(beg->num!=a)
    {
        beg=beg->next;
    }

    //printf("%d",beg->num);

    while(end->num!=b)
    {
        end=end->next;
    }

    //printf("\t%d\n",end->num);

    beg->rand=end;
    beg->ch='S';

    //printf("%d\n",beg->rand->num);
}

void display(){
    struct node *temp=start;
    while(temp->next!=NULL)
    {
        printf("%d\n",temp->num);
        temp=temp->next;
    }
    printf("%d\n",temp->num);
}

void play()
{
    struct node *p1, *p2;
    int dval,flag,i;

    p1=start;
    p2=start;

        flag=0;

        while(flag==0)
        {
            dval=0;

            printf("\nPlayer 1 roll dice : \t");
            //printf("here");
            //printf("%d",p1->num);
            //printf("%c",p1->ch);
            scanf("%d",&dval);
            while(dval>6)
            {
                printf("\nDice value can't be greater than 6!!!\nEnter again.\t");
                scanf("%d",&dval);
            }


           // printf("%d",p1->num+dval);
            if(p1->num+dval>100)
                printf("\nNot enough spaces.. Cannot move!");
            else
                for(i=0;i<dval;i++)
                {
                    p1=p1->next;
                }
            if(p1->ch=='S')
            {
                printf("\nOops! You got bitten by a snake. :(");
                p1=p1->rand;
            }
            if(p1->ch=='L')
            {
                printf("\nYay! You've landed on a ladder. :D");
                p1=p1->rand;
            }
            printf("\nYou are now on %d", p1->num);
            if(p1->num==100)
            {
                printf("\n\nCONGRATULATIONS! PLAYER 1 WINS!!!");
                flag=1;
                break;
            }



            printf("\nPlayer 2 roll dice : \t");
            scanf("%d",&dval);
            while(dval>6)
            {
                printf("\nDice value can't be greater than 6!!!\nEnter again.\t");
                scanf("%d",&dval);
            }

            if(p2->num+dval>100)
                printf("\nNot enough spaces.. Cannot move!");
            else
                for(i=0;i<dval;i++)
                {
                    p2=p2->next;
                }
            if(p2->ch=='S')
            {
                printf("\nOops! You got bitten by a snake. :(");
                p2=p2->rand;
            }
            if(p2->ch=='L')
            {
                printf("\nYay! You've landed on a ladder. :D");
                p2=p2->rand;
            }
            printf("\nYou are now on %d", p2->num);
            if(p2->num==100)
            {
                printf("\n\nCONGRATULATIONS! PLAYER 2 WINS!!!");
                flag=1;
                break;
            }
        }
}

void main()
{
    newGame();
    play();
}
