package _2017xiaozhao;

import medium.IntegerBreak;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 ����n�������������������ӳ�һ�ţ����һ�����Ķ�λ������
 ��:n=3ʱ��3������13,312,343,���ɵ��������Ϊ34331213��
 ��:n=4ʱ,4������7,13,4,246���ӳɵ��������Ϊ7424613��
 ��������:
 �ж������������ÿ����������������У���һ��Ϊһ������N��N<=100�����ڶ��а���N����(ÿ����������1000���ո�ֿ�)��
 �������:
 ÿ���������һ����ʾ����������
 ʾ��1
 ����

 2
 12 123
 4
 7 13 4 246
 ���

 12312
 7424613
 */
/*
���������˼�룬ע�����ﲻ��ʹ��int���ͱȽϴ�С��Ӧ��ʹ��string�������Ƚ����ִ�С


 */
public class ���� {
    public static String getIntString(int[] array)
    {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<array.length;i++)
        {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }
    public static void swap(int[] array,int p,int q)
    {
        int temp=array[p];
        array[p]=array[q];
        array[q]=temp;
    }
    public static String getMax(int[] array)
    {
        for (int i=1;i<array.length;i++)
        {
            int j=i;
            String m1="";
            String m2="";
            while (m2.compareTo(m1)>=0&&j>=1)
            {
                m1=getIntString(array);
                swap(array,j,j-1);
                m2=getIntString(array);
                if(m2.compareTo(m1)<0)
                {
                    swap(array,j,j-1);
                    break;
                }
                j--;
            }

        }
        return getIntString(array);
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int length=scanner.nextInt();
            int[] array=new int[length];
            for (int i=0;i<length;i++)
            {
                array[i]=scanner.nextInt();
            }
            System.out.println(getMax(array));
        }
    }
}
