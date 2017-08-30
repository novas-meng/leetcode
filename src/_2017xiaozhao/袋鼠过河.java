package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * һֻ����Ҫ�Ӻ���������Ӷ԰����Ӻܿ����Ǻ��м���˺ܶ�׮�ӣ�ÿ��һ�׾���һ����ÿ��׮���϶���һ�����ɣ��������������ϾͿ������ĸ�Զ��ÿ������������ͬ����һ�����ִ������������������������Ϊ5���ʹ��������һ������ܹ���5�ף����Ϊ0���ͻ��ݽ�ȥ�޷�������Ծ������һ��N�׿������ʼλ�þ��ڵ�һ���������棬Ҫ�������һ������֮���������ˣ�����ÿ�����ɵ������������������Ҫ�������ܹ�����԰�������޷��������-1
 ��������:
 ��������У���һ�������鳤��N (1 �� N �� 10000)���ڶ�����ÿһ���ֵ���ÿո�ָ���
 �������:
 ������ٵ��������޷��������-1
 ʾ��1
 ����

 5
 2 0 1 1 1
 ���

 4
 */


public class ������� {
    /*
    ˼·����
    ��1���������ж��ܷ���ӣ�Ҳ���Ǳ���array[5]=0 ��ô���ж���5 ���λ��֮ǰ���Ƿ��������5��ʹ��max��¼���������������룬���
    max > 5 ��˵����������0����ط������С��5��ֱ�ӷ���-1����


    ʹ������step[i] step[i] ��ʾ����iλ����Ҫ����С����
   ��2�� �������飬��������array[i],��������array[3]=3,��ʾ�������Ϊ3��Ҳ����˵��������
   4 5 6������λ�ã�ʹ�õ�����Ϊstep[3]+1,
   Ȼ��ȡmin(step[4],step[3]+1)��Ϊstep[4]��ֵ

   �ٸ����� 3 0 3 1 1
   ����array[0]��˵������array[2]����õ�ѡ�񣬶�����array[3]


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
