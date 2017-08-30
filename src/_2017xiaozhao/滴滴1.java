package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 */
public class µÎµÎ1 {
    public static int maxSubArray(int[] nums) {
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;i++)
        {
            sum[i]=Math.max(sum[i-1]+nums[i],nums[i]);
            if(sum[i]>max)
            {
                max=sum[i];
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            int[] array=new int[var.length];
            for (int i=0;i<array.length;i++)
            {
                array[i]=Integer.valueOf(var[i]);
            }
            System.out.println(maxSubArray(array));
        }
    }
}
