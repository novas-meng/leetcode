package _2017xiaozhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by novas on 2017/8/28.
 */
public class sohu1 {
    public static void getStr(int[] array,int n)
    {
        int[] res=new int[n];
        int outbegin=0;
        int inbegin=0;
        int index=0;
        for (int i=0;i<array[index];i++)
        {
            res[inbegin]=array[index];
            inbegin++;
        }
        outbegin=1;
        index=1;

        while (true)
        {
            if(inbegin==outbegin)
            {
                for (int i=0;i<array[index];i++)
                {
                    res[inbegin]=array[index];
                    inbegin++;
                    if(inbegin==n)
                    {
                        for (int j=0;j<n;j++)
                        {
                            System.out.println(res[j]);
                        }
                        return;
                    }
                }
                index++;
                outbegin++;
                if(index==array.length)
                {
                    index=0;
                }

            }
            int item=res[outbegin];
            for (int i=0;i<item;i++)
            {
                res[inbegin]=array[index];
                inbegin++;
                if(inbegin==n)
                {
                    for (int j=0;j<n;j++)
                    {
                        System.out.println(res[j]);
                    }
                    return;
                }
            }
            index++;
            if(index==array.length)
            {
                index=0;
            }
            outbegin++;
        }

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] array=new int[m];
            for (int i=0;i<m;i++)
            {
                array[i]=scanner.nextInt();
            }
            getStr(array,n);
        }
    }
}
