package _2017xiaozhao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 *
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上�?有的父子关系，求这棵树的高度
 输入描述:
 输入的第�?行表示节点的个数n�?1 �? n �? 1000，节点的编号�?0到n-1）组成，
 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编�?
 输出描述:
 输出树的高度，为�?个整�?
 示例1
 输入

 5
 0 1
 0 2
 1 3
 1 4
 输出

 3
 *
 */
public class ���ĸ߶� {
    public static int getHeight(int[][] array)
    {
        int root=0;
        for (int i=0;i<array.length;i++)
        {
            int sum=0;
            for (int j=0;j<array.length;j++)
            {
                sum=sum+array[j][i];
            }
            if(sum==0)
            {
                root=i;
            }
        }
        System.out.println("root="+root);
        int count=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(root);
        while (true)
        {
            Queue<Integer> tempqueue=new LinkedList<>();
            while (!queue.isEmpty())
            {
                int parent=queue.poll();
                for (int i=0;i<array.length;i++)
                {
                    if(array[parent][i]==1)
                    {
                        tempqueue.add(i);
                    }
                }
            }
            if(tempqueue.isEmpty())
            {
                break;
            }
            else
            {
                count++;
                queue.clear();
                queue.addAll(tempqueue);
            }
        }

        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n=scanner.nextInt();
            int[][] array=new int[n][n];
            for (int i=0;i<n-1;i++)
            {
                array[scanner.nextInt()][scanner.nextInt()]=1;
            }
            System.out.println(getHeight(array));
        }
    }
}
