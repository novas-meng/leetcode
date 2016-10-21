import java.util.ArrayList;

/**
 * Created by novas on 2016/10/18.
 */
public class IsomorphicStrings {
    public static void main(String[] args)
    {
       String s="egg";
        String t="add";
        System.out.println(isIsomorphic(s,t));
    }
    public static String toArray(String s)
    {
        ArrayList<Character> characters=new ArrayList<>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++)
        {
            if(!characters.contains(chars[i]))
            {
                characters.add(chars[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++)
        {
            int loc=characters.indexOf(chars[i]);
            sb.append(loc+"");
        }
        return sb.toString();
    }
    public static boolean isIsomorphic(String s, String t) {
        String var1=toArray(s);
        String var2=toArray(t);
        return var1.equals(var2);
    }
}
