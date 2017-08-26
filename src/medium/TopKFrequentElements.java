package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by novas on 2017/3/2.
 */
public class TopKFrequentElements {
    public static void main(String[] args)
    {
        int[] array={1,2};
        int[] res=heapsort(array);
        for (int i=0;i<res.length;i++)
        {
            System.out.println(res[i]);
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
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
        int[] array=new int[map.size()];
        int count=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            array[count++]=entry.getValue();
        }
        array=heapsort(array);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<k;i++)
        {
            for (Map.Entry<Integer,Integer> entry:map.entrySet())
            {
                if(entry.getValue()==array[i])
                {
                    if(!list.contains(entry.getKey()))
                    list.add(entry.getKey());
                }
            }
        }
        return list;
    }
    public static int[] heapsort(int[] array)
    {
        for (int i=array.length/2-1;i>=0;i--)
        {
            System.out.println("i="+i);
            array=pushdown(i,array,array.length);
        }
        for (int i=array.length-1;i>=1;i--)
        {
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            array=pushdown(0,array,i);
        }
        return array;
    }
    public static int[] pushdown(int index,int[] array,int n)
    {
        while (2*index+1<n)
        {
            int left=2*index+1;
            int right=2*index+2;
            int leftValue=array[left];
            int rightValue=Integer.MAX_VALUE;
            if(right<n)
            {
                rightValue=array[right];
            }
           // System.out.println("left="+leftValue+","+rightValue);
            if(leftValue<=rightValue)
            {
                if(leftValue<array[index])
                {
                    int temp=array[index];
                    array[index]=leftValue;
                    leftValue=temp;
                    index=left;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(rightValue<array[index])
                {
                    int temp=array[index];
                    array[index]=rightValue;
                    rightValue=temp;
                    index=right;
                }
                else
                {
                    break;
                }
            }
            array[left]=leftValue;
            if(right<n)
            {
                array[right]=rightValue;
            }
            for (int i=0;i<n;i++)
            {
               // System.out.print(array[i] + ",");
            }
            System.out.println();
        }
        return array;
    }
}
