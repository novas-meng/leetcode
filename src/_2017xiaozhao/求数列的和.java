package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * ���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
 ��������:
 ���������ж��飬ÿ��ռһ�У�����������n��n < 10000����m(m < 1000)��ɣ�n��m�ĺ�����ǰ������
 �������:
 ����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����
 ʾ��1
 ����

 81 4
 2 2
 ���

 94.73
 3.41
 */
public class �����еĺ� {
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
