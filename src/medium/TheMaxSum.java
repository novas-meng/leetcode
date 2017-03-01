package medium;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Created by novas on 2017/2/28.
 */
/*
例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
输入描述:
输入为两行。
第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素
第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
输出描述:
所有连续子数组中和最大的值。
 */
public class TheMaxSum {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[] array=new int[length];
        for (int i=0;i<array.length;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println(maxSum(array));
    }
    public static int maxSum(int[] array)
    {
        int max=array[0];
        int[] B=new int[array.length];
        B[0]=array[0];
        for (int i=1;i<array.length;i++)
        {
            if(B[i-1]<0)
            {
                B[i]=array[i];
            }
            else
            {
                B[i]=array[i]+B[i-1];
            }
            if(B[i]>max)
            {
                max=B[i];
            }
        }
        return max;
    }
}
