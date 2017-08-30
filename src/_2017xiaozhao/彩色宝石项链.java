package _2017xiaozhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * ��һ����ɫ��ʯ���������ɺܶ��ֲ�ͬ�ı�ʯ��ɵģ������챦ʯ������ʯ����ʯ����䣬����ȡ�
 * ��һ������������ʹ͸���һ��ѧ�ߣ�������˵������Դ����������������������ϲ���챦ʯ������ʯ����ˮ����������ʯ�����֣�
 * ��Ҫ��������н�ȡ������һС�λ����ң���һ���б���������е������ֱ�ʯ��ʣ�µĲ�������Դ��ߡ�����޷��ҵ���һ��Ҳ�޷����ߡ�
 * �����ѧ���ҳ�����з��������ܹ��õ����ı�ʯ��
 ��������:
 ������ÿ���ַ�����һ�ֱ�ʯ��A��ʾ�챦ʯ��B��ʾ����ʯ��C������ˮ����D������䣬E������ʯ��F������ʯ��G�������ȵȣ�
 ������һ��ȫ��Ϊ��д��ĸ���ַ����б�ʾ�����ı�ʯ���У�ע����������β��ӵġ�ÿ�д���һ�������
 �������:
 ���ѧ���ܹ��õ������ı�ʯ������ÿ��һ��
 ʾ��1
 ����

 ABCYDYE
 ATTMBQECPD
 ���

 1
 3
 */
public class ��ɫ��ʯ���� {
    /*
    ˼· ʹ��queue������ĸ���ֵ�λ�ã�ʹ������Ϊ5�����鱣��queue
    ����ATTMBQECPD

    queues[0] ����A���ֵ�λ�ã�queues[1]����B���ֵ�λ�� queues[2] ����C���ֵ�λ��
    queues[3] ����D���ֵ�λ�� queues[4] ����E���ֵ�λ��

    ������queues��ʱ����Ϊ��һ���������Խ��ַ���ƴ�����������2��
            for (int i=0;i<2*chars.length-1;i++)
        {
            if(chars[i%chars.length]=='A'||chars[i%chars.length]=='B'||chars[i%chars.length]=='C'||chars[i%chars.length]=='D'||chars[i%chars.length]=='E')
            {
                queues[chars[i%chars.length]-'A'].add(i);
            }
        }




    ʹ��first�������ÿһ��λ�ã��Ӹ�λ�ÿ�ʼ��A B C D E ���ֵ�λ��
    ��ʼ��firstΪ queues�ĵ�һ��Ԫ��


    Ȼ������ַ����飬������� A B C D E ������chars[5]='B'��Ȼ�����first���飬���first[0]С��
    5,˵����Ҫ��5��������һ��A�����ʱ�򣬽�queues[0] ��һ��Ԫ�س��ӣ����first[0]

    ���Եó���ÿ��ֻ�����һ��Ԫ��





     */
    public static int getMax(String str)
    {
        /*
           ʹ��queue������ĸ���ֵ�λ�ã�ʹ������Ϊ5�����鱣��queue
         */
        Queue<Integer>[] queues=new Queue[5];
        for (int i=0;i<queues.length;i++)
        {
            queues[i]=new LinkedList<>();
        }
        char[] chars=str.toCharArray();

        //�ҵ�A B C D E��һ�γ��ֵĵط�
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

        //�ڶ��α������ҵ�����������
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
