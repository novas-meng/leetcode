package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 输入描述:
 输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
 输出描述:
 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 示例1
 输入

 81 4
 2 2
 输出

 94.73
 3.41
 */
public class 求数列的和 {
    public static void printSum(int n,int m)
    {
        double sum=0;
        double p=n;
        for (int i=0;i<m;i++)
        {
            sum=sum+p;
            p=Math.sqrt(p);
        }
        System.out.printf("%.2f\n",sum);
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            printSum(n,m);
        }
    }
}
