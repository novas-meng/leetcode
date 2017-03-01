package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novas on 2016/10/15.
 */
public class PascalsTriangleII {
    public static void main(String[] args)
    {
        System.out.println(C(31,14));
    }
    /*
    public static int C(int n,int m)
    {
        if(m==n||m==0)
        {
            return 1;
        }
        return C(n-1,m)+C(n-1,m-1);
    }
    */
    public static int C(int n,int m)
    {
        if(m>n/2)
        {
            m=n-m;
        }
        double sum1=1;
        for(int i=n;i>=(n-m+1);i--)
        {
            sum1=sum1*i;
        }
        double sum2=1;
        for(int i=1;i<=m;i++)
        {
            sum2=sum2*i;
        }
        return (int)Math.ceil(sum1/sum2);
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<rowIndex;i++)
        {
            int n=rowIndex-1;
            int m=i;
            if(m>n/2)
            {
                m=n-m;
            }
            list.add(C(n,m));
        }
       return list;
    }
}
