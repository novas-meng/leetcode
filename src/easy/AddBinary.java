package easy;

/**
 * Created by novas on 2016/11/13.
 */
public class AddBinary {
    public static void main(String[] args)
    {
        System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b) {
        char[] a_array=a.toCharArray();
        char[] b_array=b.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        int times=0;
        int length=Math.max(a_array.length,b_array.length);
        int i=0;
        while (i<length)
        {
            int a_int=0;
            int b_int=0;
           if(i<a_array.length)
           {
               a_int=(int)a_array[a_array.length-1-i]-48;
           }
            if(i<b_array.length)
            {
                b_int=(int)b_array[b_array.length-1-i]-48;
            }
            System.out.println(a_int+"   "+b_int);
            int mod=(a_int+b_int+times)%2;
            times=(a_int+b_int+times)/2;
            stringBuilder.append(mod);
            i++;
        }
        if(times==1)
        stringBuilder.append(times);
        StringBuilder res=new StringBuilder();
        for (int j=0;j<stringBuilder.length();j++)
        {
            res.append(stringBuilder.charAt(stringBuilder.length()-1-j));
        }
        return res.toString();
    }
}
