package medium;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by novas on 2017/3/20.
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args)
    {
        int[] array={1,3,4,3,2};
        System.out.println(findDuplicate(array));

    }
    public static int findDuplicate(int[] nums) {
        int start=1;
        int end=nums.length-1;
        int mid=0;
        while (start<=end)
        {
             mid=start+(end-start)/2;
            int count=0;
            for (int i=0;i<nums.length;i++)
            {
                if(nums[i]<=mid)
                {
                    count++;
                }
            }
            System.out.println("mid="+mid+"  "+count);
            if(count>mid)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return start;
    }
}
