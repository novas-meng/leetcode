package medium;

/**
 * Created by novas on 2017/3/2.
 */
public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args)
    {
        int[] array={203125577,-349566234,230332704,48321315,66379082,386516853,50986744,
                -250908656,-425653504,-212123143};
        System.out.println(minMoves2(array));
    }
    public static long minMoves2(int[] nums) {
        double min=Double.MAX_VALUE;
        int choosednum=0;
        for (int i=0;i<nums.length;i++)
       {
           double temp=0;
           for (int j=0;j<nums.length;j++)
           {
               if(nums[j]>nums[i])
               {
                   temp=temp+nums[j]-nums[i];
                //   System.out.println("temp="+temp);
               }
           }
         //  System.out.println("nums[i]="+nums[i]+","+temp+","+Double.MAX_VALUE);
           double L=nums.length;
           L=L*nums[i];
          // System.out.println(2*temp+","+L);
           temp=2*temp+L;
          // System.out.println("nums[i]="+nums[i]+","+temp);
           if(temp<min)
           {
               min=temp;
               choosednum=nums[i];
           }
       }
        //System.out.println(choosednum);
        long m=0;
        for (int i=0;i<nums.length;i++){
            m=m+Math.abs(nums[i]-choosednum);
        }
        return m;
    }
}
