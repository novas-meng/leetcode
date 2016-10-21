/**
 * Created by novas on 2016/10/19.
 */
public class CountandSay {
    public static void main(String[] args)
    {
        System.out.println(countAndSay(4));
    }
    public static String getCoutAndSay(String s)
    {
        char[] array=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<array.length;)
        {
            int j=i;
            int count=0;
            while (j<array.length&&array[j]==array[i])
            {
                count++;
                j++;
            }
            sb.append(count).append(array[i]);
            i=j;
        }
        return sb.toString();
    }
    public static String countAndSay(int n) {
        String last="1";
        for(int i=1;i<n;i++)
        {
            last=getCoutAndSay(last);
        }
        return last;
    }
}
