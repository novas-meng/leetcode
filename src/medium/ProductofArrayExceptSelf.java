package medium;

/**
 * Created by novas on 2017/3/2.
 */
public class ProductofArrayExceptSelf {
    public static void main(String[] args)
    {
        int[] array={1,2,3,4};
        productExceptSelf(array);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] before=new int[nums.length];
        int[] after=new int[nums.length];
        before[0]=1;
        after[nums.length-1]=1;
        for (int i=1;i<before.length;i++)
        {
            before[i]=before[i-1]*nums[i-1];
        }
        for (int i=0;i<before.length;i++)
        {
           // System.out.println(before[i]);
        }
        for (int i=nums.length-2;i>=0;i--)
        {
            after[i]=after[i+1]*nums[i+1];
        }
        for (int i=0;i<after.length;i++)
        {
           // System.out.println(after[i]);
        }
        int[] result=new int[nums.length];
        for (int i=0;i<result.length;i++)
        {
            result[i]=before[i]*after[i];
        }
        return result;
    }
}
