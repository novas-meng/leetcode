package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 */
public class µÎµÎ2 {
    public static void putdown(int[] array,int root,int length)
    {
        int p=root;
        while (p<=(length+1)/2-1)
        {
            int leftchild=2*p+1;
            int rightchild=2*p+2;
            if(rightchild<length)
            {
                if(array[leftchild]>=array[rightchild]&&array[leftchild]>array[p])
                {
                    int temp=array[leftchild];
                    array[leftchild]=array[p];
                    array[p]=temp;
                    p=leftchild;
                }
                else if(array[rightchild]>=array[leftchild]&&array[rightchild]>array[p])
                {
                    int temp=array[rightchild];
                    array[rightchild]=array[p];
                    array[p]=temp;
                    p=rightchild;
                }
                else
                {
                    break;
                }

            }
            else if(leftchild<length)
            {
                if(array[leftchild]>array[p])
                {
                    int temp=array[leftchild];
                    array[leftchild]=array[p];
                    array[p]=temp;
                    p=leftchild;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
    }

    public static int getK(int[] array,int k)
    {
        int index=1;
        for (int i=(array.length+1)/2-1;i>=0;i--)
        {
            putdown(array,i,array.length);
        }
        int count=array.length-1;
        while (count>0)
        {
            if(index==k)
            {
                return array[0];
            }
            int temp=array[count];
            array[count]=array[0];
            array[0]=temp;
            for (int i=(count+1)/2-1;i>=0;i--)
            {
                putdown(array,i,count);
            }
            count--;
            index++;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            int k=scanner.nextInt();
            String[] var=line.split(" ");
            int[] array=new int[var.length];
            for (int i=0;i<array.length;i++)
            {
                array[i]=Integer.valueOf(var[i]);
            }
            System.out.println(getK(array,k));
        }
    }
}
