package easy;

/**
 * Created by novas on 2017/2/24.
 */
public class LongestCommonPrefix {
    public static void main(String[] args)
    {
        String[] strs={};
        System.out.println(longestCommonPrefix(strs));

    }
    public  static String longestCommonPrefix(String[] strs) {
        int minlength=Integer.MAX_VALUE;
        String str="";
        for (int i=0;i<strs.length;i++)
        {
            if(strs[i].length()<minlength)
            {
                minlength=strs[i].length();
                str=strs[i];
            }
        }
        for (int i=0;str!=null&&i<str.length();i++)
        {
            for (int j=0;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=str.charAt(i))
                {
                    return "\""+str.substring(0,i)+"\"";
                }
            }
        }
        return str;
    }
}
