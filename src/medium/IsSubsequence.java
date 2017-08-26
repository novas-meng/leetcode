package medium;

/**
 * Created by novas on 2017/3/10.
 */
public class IsSubsequence {
    public static void main(String[] args)
    {
        String s="abcg";
        String t="abcde";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        char[] s_array=s.toCharArray();
        char[] t_array=t.toCharArray();
        int begin=-1;
        int temp;
        for (int i=0;i<s_array.length;i++)
        {
            temp=begin;
            for (int j=begin+1;j<t_array.length;j++)
            {
                if(t_array[j]==s_array[i])
                {
                    begin=j;
                    break;
                }
            }
            if(temp==begin)
            {
                return false;
            }
        }
        return true;
    }
}
