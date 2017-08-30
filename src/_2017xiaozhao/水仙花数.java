package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 输入描述:
 输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
 输出描述:
 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
 如果给定的范围内不存在水仙花数，则输出no;
 每个测试实例的输出占一行。
 示例1
 输入

 100 120
 300 380
 输出

 no
 370 371
 */
public class 水仙花数 {
    public static void print(int[] array)
    {
        int begin=array[0];
        int end=array[1];
        int count=0;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=begin;i<=end;i++)
        {
            char[] chars=(i+"").toCharArray();
            int sum=0;
            for (int j=0;j<chars.length;j++)
            {
                int m=chars[j]-'0';
                sum=sum+m*m*m;
            }
            if(sum==i)
            {
                count++;
                stringBuilder.append(i+" ");
            }
        }
        if(count==0)
        {
            System.out.println("no");
        }
        else
        {
            System.out.println(stringBuilder.toString().substring(0,stringBuilder.toString().length()-1));
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            int[] array=new int[2];
            array[0]=Integer.valueOf(var[0]);
            array[1]=Integer.valueOf(var[1]);
            print(array);
        }
    }

}
