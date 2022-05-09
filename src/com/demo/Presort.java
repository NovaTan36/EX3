package com.demo;

import java.util.Scanner;

public class Presort {
    int [] numbers;
    Scanner s =new Scanner(System.in);

    public Presort()
    {
        System.out.print("请输入需要排列的总数：");
        numbers =new int[s.nextInt()];
        System.out.println("请输入需要排列的数字（空格分割）：");
        for (int i=0;i<numbers.length;i++)
        {
            numbers[i]=s.nextInt();
        }


        for (int number : numbers) {
            System.out.print(number);
            System.out.print(",");
        }
        System.out.println();
    }

    private void count(int num,int total)
    {
        total--;
        for (int i=0;i<=total;)
        {
            toSort(numbers,i,i+num,total);
            i+=2*num;
            if(i>total)i=total;
        }
    }
    private boolean compare(int a,int b)
    {
        if (a<b)return true;
        else return false;
    }
    private void toSort(int[] numbers,int start,int end,int allEnd)
    {
        int tol=end-start;
        int head[]=new int[tol];
        for (int i=start,j=0;i<tol;i++,j++)head[j]=numbers[i];      //第一个比较队列放入新的数组中
        for(int i=0,flag=start;i<tol;)
        {
            if (compare(numbers[end], head[i]))                 //尾队列小于头队列
            {                                                   //尾队列赋值主队列，各自标记+1
                numbers[flag]=numbers[end];
                flag++;
                end++;
            }
            else
            {
                /*
                i++;                                        //
                flag++;
                 */
            }
            if (i==head.length)break;               //头队列为空时尾队列不用赋值，其本身就在主队列
            if (end==allEnd)                        //尾队列为空时如果头队列有剩余全部赋值会主队列
            {
                for (int last=i;i< head.length;i++)
                {
                    numbers[flag]=head[i];

                }
            }
        }


    }


}
