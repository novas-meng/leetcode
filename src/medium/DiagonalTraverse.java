package medium;

import java.util.ArrayList;

/**
 * Created by novas on 2017/3/3.
 */
public class DiagonalTraverse {
    public static void main(String[] args)
    {
        int[][] array={{1}};
        int[] res=findDiagonalOrder(array);
        for (int i=0;i<res.length;i++)
        {
            System.out.println(res[i]);
        }
    }
    public static int[] findDiagonalOrder(int[][] matrix) {
        int hangall=matrix.length;
        if(hangall==0)
            return new int[0];
        int lieall=matrix[0].length;

        int[] result=new int[hangall*lieall];

        int index=0;
        result[index]=matrix[0][0];

        int hangbegin=0;
        int liebegin=0;
       // System.out.println(matrix[hangbegin][liebegin]);
        int lie=1;
        int hang=0;
        while (true)
        {

            if(lie==1)
            {
                if(liebegin+lie>=lieall)
                {
                    hangbegin=hangbegin+1;
                }
                else
                {
                    liebegin=liebegin+1;
                }
            }
            else
            {
                if(hangbegin+hang>=hangall)
                {
                    liebegin=liebegin+1;
                }
                else
                {
                    hangbegin=hangbegin+1;
                }
            }
            index++;
            if(liebegin>lieall-1||hangbegin>hangall-1)
                return result;
            result[index]=matrix[hangbegin][liebegin];
            // System.out.println(matrix[hangbegin][liebegin]);
            if(lie==1)
            {
                //列减少
                while (liebegin>0&&hangbegin<hangall-1)
                {
                    hangbegin++;
                    liebegin--;
                    index++;
                    result[index]=matrix[hangbegin][liebegin];
                    //System.out.println(matrix[hangbegin][liebegin]);
                }
            }
            else
            {
                //列增加
                while (liebegin<lieall-1&&hangbegin>0)
                {
                    hangbegin--;
                    liebegin++;
                    index++;
                    result[index]=matrix[hangbegin][liebegin];
                   // System.out.println(matrix[hangbegin][liebegin]);
                }
            }
            lie=1-lie;
            hang=1-hang;
           // System.out.println("hangbegin="+hangbegin+","+liebegin);
            if(liebegin==lieall-1&&hangbegin==hangall-1)
            {
                break;
            }
        }
        return result;
    }
}
