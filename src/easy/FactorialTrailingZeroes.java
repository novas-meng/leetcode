package easy;

/**
 * Created by novas on 2016/10/15.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
       int sum=0;
        while (n>0)
        {
            n=n/5;
            sum=sum+n;
        }
        return sum;
    }
}
