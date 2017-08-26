package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by novas on 2017/3/12.
 */
public class _4SumII {
    public HashMap<Integer,Integer> getTwoSum(int[] A,int[] B)
    {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<A.length;i++)
        {
            for (int j=0;j<B.length;j++)
            {
                int sum=A[i]+B[j];
                if(hashMap.containsKey(sum))
                {
                    hashMap.put(sum,hashMap.get(sum)+1);
                }
                else
                {
                    hashMap.put(sum,1);
                }
            }
        }
        return hashMap;
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ABmap=getTwoSum(A,B);
        HashMap<Integer,Integer> CDmap=getTwoSum(C,D);
        int sum=0;
        for (Map.Entry<Integer,Integer> entry:ABmap.entrySet())
        {
            double l=0.0-entry.getKey();
            if(CDmap.containsKey(l))
            {
                sum=sum+entry.getValue()*CDmap.get(l);
            }
        }
        return sum;
    }
}
