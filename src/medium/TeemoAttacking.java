package medium;

/**
 * Created by novas on 2017/3/1.
 */
public class TeemoAttacking {
    public static void main(String[] args)
    {
        int[] array={1,4};
        int duration=2;
        System.out.println(findPoisonedDuration(array,duration));
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int begin_time=0;
        int end_time=-1;
        int sum=0;
        for (int i=0;i<timeSeries.length;i++)
        {
            if(timeSeries[i]>end_time)
            {
                sum=sum+end_time-begin_time+1;
                begin_time=timeSeries[i];
              //  System.out.println("sum="+sum);
            }
            end_time=timeSeries[i]+duration-1;
           // System.out.println("end="+end_time+","+begin_time);
        }
       // System.out.println(begin_time+","+end_time);
        sum=sum+end_time-begin_time+1;
        return sum;
    }
}
