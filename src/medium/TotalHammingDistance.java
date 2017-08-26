package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by novas on 2017/3/6.
 */
public class TotalHammingDistance {
    public static void main(String[] args)
    {
        int[] array={4,14,2,4,14,2};
        System.out.println(totalHammingDistance(array));
    }
    public static int totalHammingDistance(int[] nums) {
        int[] count_0=new int[32];
        int[] count_1=new int[32];
        for (int i=0;i<nums.length;i++)
        {
            for (int j=0;j<32;j++)
            {
                int l=nums[i]-(nums[i]>>1)*2;
                if(l==1)
                {
                    count_1[j]++;
                }
                else
                {
                    count_0[j]++;
                }
                nums[i]=nums[i]>>1;
                //  System.out.println("m="+m);
            }
        }
        int sum=0;
        for (int i=0;i<count_0.length;i++)
        {
            sum=sum+count_0[i]*count_1[i];
        }
        return sum;
    }
}
