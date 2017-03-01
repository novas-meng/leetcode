package easy;

import java.util.HashMap;

/**
 * Created by novas on 2016/10/26.
 */
public class ContainsDuplicateII {
    public static void main(String[] args)
    {
        double m1=-1*2.0/4.0*(Math.log(2.0/4.0)/Math.log(2))-1*2.0/4.0*(Math.log(2.0/4.0)/Math.log(2));
        double m2=-1*2.0/5.0*(Math.log(2.0/5.0)/Math.log(2))-1*3.0/5.0*(Math.log(3.0/5.0)/Math.log(2));
        // System.out.println(m);
       //get();
        System.out.println(0.991-4.0/9.0*m1-5.0/9.0*m2);
    }
    public static void get()
    {
        double H=0.991;
        int[] a_array={1,3,4,5,5,6,7,7,8};
        int[] b_array={1,-1,1,-1,-1,1,-1,1,-1};
        int onecount=4;
        int zerocount=5;
        for (int i=0;i<a_array.length-1;i++)
        {
            int a=0;
            int b=0;
            for (int j=i+1;j<b_array.length;j++)
            {
                if(b_array[j]==1)
                {
                    a++;
                }
                else
                {
                    b++;
                }
            }
            int aa=onecount-a;
            int bb=zerocount-b;
            System.out.println(aa+"   "+bb);
            double d1=(aa+0.0)/(aa+bb+0.0);
            double d2=1-d1;
            double c1=0;
            if(d1==0||d2==0)
            {
                c1=0;
            }
            else
            {
                 c1=-1*d1*(Math.log(d1)/Math.log(2))-d2*(Math.log(d2)/Math.log(2));
            }
            //System.out.println(c1);
            double d3=(a+0.0)/(a+b+0.0);
            double d4=(b+0.0)/(a+b+0.0);
            double c2=0;
            if(d3==0||d4==0)
            {
                c2=0;
            }
            else
            {
                 c2=-1*d3*(Math.log(d3)/Math.log(2))-d4*(Math.log(d4)/Math.log(2));
            }

            double m=H-(aa+bb+0.0)/9*c1-(a+b+0.0)/9*c2;

            double d5=(i+1.0)/9.0;
            double d6=1-d5;
            double c3=-1*d5*(Math.log(d5)/Math.log(2))-d6*(Math.log(d6)/Math.log(2));
            System.out.println(m/c3);
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
           if(map.containsKey(nums[i]))
           {
               int last=map.get(nums[i]);
               if(i-last<=k)
               {
                   return true;
               }
               else
               {
                   map.put(nums[i],i);
               }
           }
            else
           {
               map.put(nums[i],i);
           }
        }
        return false;
    }
}
