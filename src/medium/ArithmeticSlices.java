package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by novas on 2017/2/26.
 */
public class ArithmeticSlices {
    public static void main(String[] args)
    {
        int[] A={1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(A));
    }
    public static int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int minus=0;
        int count=0;
        for (int i=0;i<A.length-1;)
        {
            if(A[i+1]-A[i]==minus)
            {
                count++;
                i++;
            }
            else
            {
                map.put(i,count);
                count=0;
                minus=A[i+1]-A[i];
            }
        }
        map.put(minus,count);
        int sum=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
          //  System.out.println(entry.getKey()+","+entry.getValue());
            if(entry.getValue()>=2)
            {
                sum=sum+(entry.getValue()*(entry.getValue()-1))/2;
            }
        }
        return sum;
    }
}
