package _2017xiaozhao;

import medium.IntegerBreak;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 输入描述:
 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 输出描述:
 每组数据输出一个表示最大的整数。
 示例1
 输入

 2
 12 123
 4
 7 13 4 246
 输出

 12312
 7424613
 */
/*
插入排序的思想，注意这里不能使用int类型比较大小，应该使用string类型来比较数字大小


 */
public class 数串 {
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
