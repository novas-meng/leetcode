package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 输入描述:
 输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
 输出描述:
 输出最少的跳数，无法到达输出-1
 示例1
 输入

 5
 2 0 1 1 1
 输出

 4
 */


public class 袋鼠过河 {
    /*
    思路介绍
    （1）首先是判断能否过河，也就是比如array[5]=0 那么就判断在5 这个位置之前，是否可以跳过5，使用max记录可以跳过的最大距离，如果
    max > 5 ，说明可以跳过0这个地方，如果小于5，直接返回-1即可


    使用数组step[i] step[i] 表示跳到i位置需要的最小步数
   （2） 遍历数组，对于数组array[i],假设数组array[3]=3,表示最大跳数为3，也就是说可以跳到
   4 5 6这三个位置，使用的跳数为step[3]+1,
   然后取min(step[4],step[3]+1)作为step[4]的值

   举个例子 3 0 3 1 1
   对于array[0]来说，跳到array[2]是最好的选择，而不是array[3]


     */
    public static int getMin(int[] array)
    {
        int[] step=new int[array.length+1];
        int max=0;
        for (int i=0;i<array.length;i++)
        {
            if(i==0)
            {
                for (int j=1;j<=array[i];j++)
                {
                    step[j]=1;
                }
                max=array[i];
            }
            else if(array[i]==0)
            {
                if(max<=i)
                {
                    return -1;
                }
            }
            else
            {
                if(array[i]+i>max)
                {
                    max=array[i]+i;
                }
                for (int j=i;j<Math.min(step.length-1,i+array[i]);j++)
                {
                    if(step[j+1]==0)
                    {
                        step[j+1]=1+step[i];
                    }
                    else
                    {
                        step[j+1]=Math.min(step[j+1],1+step[i]);
                    }
                }
            }
        }
        return step[step.length-1];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int[] array=new int[n];
            for (int i=0;i<array.length;i++)
            {
                array[i]=scanner.nextInt();
            }
            System.out.println(getMin(array));
        }
    }
}
