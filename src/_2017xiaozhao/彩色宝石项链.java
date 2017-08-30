package _2017xiaozhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
 * 有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，
 * 我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。
 * 请帮助学者找出如何切分项链才能够拿到最多的宝石。
 输入描述:
 我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，
 我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。
 输出描述:
 输出学者能够拿到的最多的宝石数量。每行一个
 示例1
 输入

 ABCYDYE
 ATTMBQECPD
 输出

 1
 3
 */
public class 彩色宝石项链 {
    /*
    思路 使用queue保存字母出现的位置，使用容量为5的数组保存queue
    例子ATTMBQECPD

    queues[0] 保存A出现的位置，queues[1]保存B出现的位置 queues[2] 保存C出现的位置
    queues[3] 保存D出现的位置 queues[4] 保存E出现的位置

    在生成queues的时候，因为是一个环，所以将字符串拼接起来，变成2倍
            for (int i=0;i<2*chars.length-1;i++)
        {
            if(chars[i%chars.length]=='A'||chars[i%chars.length]=='B'||chars[i%chars.length]=='C'||chars[i%chars.length]=='D'||chars[i%chars.length]=='E')
            {
                queues[chars[i%chars.length]-'A'].add(i);
            }
        }




    使用first保存对于每一个位置，从该位置开始，A B C D E 出现的位置
    初始化first为 queues的第一个元素


    然后遍历字符数组，如果碰到 A B C D E ，假设chars[5]='B'，然后遍历first数组，如果first[0]小于
    5,说明需要从5往后，在找一个A，这个时候，将queues[0] 第一个元素出队，替代first[0]

    可以得出，每次只需更改一个元素





     */
    public static int getMax(String str)
    {
        /*
           使用queue保存字母出现的位置，使用容量为5的数组保存queue
         */
        Queue<Integer>[] queues=new Queue[5];
        for (int i=0;i<queues.length;i++)
        {
            queues[i]=new LinkedList<>();
        }
        char[] chars=str.toCharArray();

        //找到A B C D E第一次出现的地方
        int[] first=new int[5];
        for (int i=0;i<first.length;i++)
        {
            first[i]=-1;
        }
        for (int i=0;i<2*chars.length-1;i++)
        {
            if(chars[i%chars.length]=='A'||chars[i%chars.length]=='B'||chars[i%chars.length]=='C'||chars[i%chars.length]=='D'||chars[i%chars.length]=='E')
            {
                queues[chars[i%chars.length]-'A'].add(i);
            }
        }
        for (int i=0;i<queues.length;i++)
        {
            first[i]=queues[i].poll();
           // System.out.println(first[i]);
        }

        //第二次遍历，找到最满足的情况
        int maxcount=0;
        for (int i=0;i<chars.length;i++)
        {
            if(chars[i]=='A'||chars[i]=='B'||chars[i]=='C'||chars[i]=='D'||chars[i]=='E')
            {
                int min=chars.length;
                int max=-1;
                for (int j=0;j<first.length;j++)
                {
                    if(first[j]<i)
                    {
                        first[j]=queues[j].poll();
                    }
                }
                for (int j=0;j<first.length;j++)
                {
                    if(first[j]>=max)
                    {
                        max=first[j];
                    }
                    if(first[j]<=min)
                    {
                        min=first[j];
                    }
                }
                int count=max-min+1;
               // System.out.println(min+","+max);
                if(chars.length-count>maxcount)
                {
                    maxcount=chars.length-count;
                }
            }
        }

        return maxcount;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            System.out.println(getMax(line));
        }
    }
}
