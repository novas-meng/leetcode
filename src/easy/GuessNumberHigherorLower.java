package easy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by novas on 2016/10/16.
 */
public class GuessNumberHigherorLower {
    static int k=6;
    public static void main(String[] args)
    {
        System.out.println(guessNumber(10));
    }

    public static int guess(int n)
    {
        if(n==k)
        {
            return 0;
        }
        if(n>k)
        {
            return 1;
        }
        return -1;
    }
    public static int guessNumber(int n) {
        double start=1;
        double end=n;
        double m=(start+end)/2;
       // System.out.println(m);
        int g=guess((int)m);
        while (g!=0)
        {
            if(g==1)
            {
                end=m-1;
            }
            else
            {
                start=m+1;
            }
            double k=(start+end);
             m=(int)(Math.floor(k/2.0));
           // System.out.println(start+"   "+end+" m="+m+"   "+k);

            g=guess((int)m);
        }
        return (int)m;
    }
}
