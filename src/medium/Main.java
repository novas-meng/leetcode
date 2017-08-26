package medium;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by novas on 2017/3/1.
 */
public class Main {
    public int demo()
    {
        return 0;
    }
    public  void  demo(String s)
    {

    }

    public static void main(String[] args) {
        int k=244;
        double[] C=new double[k+1];
        C[0]=1;
        for (int i=1;i<C.length;i++)
        {
            System.out.println(i);
            double A=1;
            for (int j=C.length-1;j>C.length-1-i;j--)
            {
                A=(A*j);

            }
            if(A>100)
            {
                A=A%100;
            }
            double B=1;
            for (int j=1;j<=i;j++)
            {
                B=(B*j);

            }
            if(B>100)
        {
            B=B%100;
        }
            if(B==0)
                C[i]=0;
            else
            C[i]=(A/B);

            System.out.println(C[i]);
        }
    }
}
