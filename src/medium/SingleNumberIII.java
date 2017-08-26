package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by novas on 2017/3/2.
 */
public class SingleNumberIII {
    public static void main(String[] args)
    {

    }
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        int length=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                length++;
            }
        }
        int[] array=new int[length];
        int count=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                array[count++]=entry.getKey();
            }
        }
        return array;
    }
}
