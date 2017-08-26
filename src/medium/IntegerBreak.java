package medium;

/**
 * Created by novas on 2017/3/9.
 */
public class IntegerBreak {
    public static void main(String[] args)
    {
        System.out.println(integerBreak(9));
    }

    public static int integerBreak(int n) {
        int[] maxarray=new int[n];
        maxarray[0]=0;
        maxarray[1]=1;
        for (int i=2;i<=n;i++)
        {
            int max=0;
            System.out.println("i="+i);
            for (int j=1;j<=i/2;j++)
            {
                int max1=Math.max(j,maxarray[j-1]);
                int max2=Math.max(i-j,maxarray[i-j-1]);
                if(max1*max2>max)
                {
                    max=max1*max2;
                }
            }
            System.out.println(max);
            maxarray[i-1]=max;
        }
        return maxarray[n-1];
    }
}
