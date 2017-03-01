package medium;

/**
 * Created by novas on 2017/3/1.
 */
public class Main {
    public static void main(String[] args)
    {
       int[] array={2,5,1,1,1,1,4,1,7,3,7};
        System.out.println(resolve(array));
    }
    static boolean resolve(int[] A) {
         double sum=0;
        for (int i=0;i<A.length;i++)
        {
            sum=sum+A[i];
        }
        int part=(int)sum/4;
        double partsum=0;
        int index=0;
        for (int i=0;i<A.length;i++)
        {
            partsum=partsum+A[i];
            if(partsum>part)
            {
               // System.out.println("index="+index+","+i);
                partsum=partsum-A[i];
                index=i-1;
                break;
            }
        }
        //System.out.println(partsum+","+index);
        while (index>0)
        {
            int B=0;
            int count=0;
            for (int i=0;i<A.length;i++)
            {
                B=B+A[i];
                if(B==partsum)
                {
                    B=0;
                    count++;
                    i++;
                }
            }
            System.out.println("index="+count);
            if(count==4)
            {
                return true;
            }
            else
            {
                partsum=partsum-A[index];
                index--;
            }
           // System.out.println(" "+partsum);
        }
       return false;
    }

}
