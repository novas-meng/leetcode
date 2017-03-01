package easy;

/**
 * Created by novas on 2016/10/14.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int start=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[start])
            {
                nums[start+1]=nums[i];
                start++;
            }
        }
        return start+1;
    }
}
