package medium;

/**
 * Created by novas on 2017/3/8.
 */
public class CountNumberswithUniqueDigits {
    public static void main(String[] args)
    {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
    public static int countNumbersWithUniqueDigits(int n) {
        int sum=10;
        int d=81;
        int result=sum+d;
        for (int i=2;i<n;i++)
        {
            int m=d;
            for (int j=2;j<=i;j++)
            {
                m=m*(10-j);
            }
            System.out.println("m="+m);
            result=result+m;
        }
        if(n==0)
        {
            return 1;
        }
        else if(n==1)
        {
            return sum;
        }
        else if(n==2)
        {
            return d+sum;
        }
        else
        {
            return result;
        }
    }
}
