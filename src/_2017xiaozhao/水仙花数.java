package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * �������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����������������ģ� ��ˮ�ɻ�������ָһ����λ�������ĸ�λ���ֵ������͵����䱾�����磺153=1^3+5^3+3^3�� ����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
 ��������:
 ���������ж��飬ÿ��ռһ�У�������������m��n��100 �� m �� n �� 999����
 �������:
 ����ÿ������ʵ����Ҫ����������ڸ�����Χ�ڵ�ˮ�ɻ���������˵�������ˮ�ɻ���������ڵ���m,����С�ڵ���n������ж������Ҫ���С����������һ���������֮����һ���ո����;
 ��������ķ�Χ�ڲ�����ˮ�ɻ����������no;
 ÿ������ʵ�������ռһ�С�
 ʾ��1
 ����

 100 120
 300 380
 ���

 no
 370 371
 */
public class ˮ�ɻ��� {
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
