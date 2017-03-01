package easy;

import java.util.Iterator;

/**
 * Created by novas on 2016/10/17.
 */
public class Brainbench<B>
{
    B b;
    public <B> void printMe(B b)
    {
        System.out.println(b.getClass().getName());
    }
    public static void main(String[] args)
    {
        String s="> this is a <";
        s=s.trim();
        s=s.replace(" ", "_");
        System.out.println(s);
        int x=0x11;
        System.out.println("x="+(int)x);
     //   System.out.println("fff "+m+f+i);
    }
}
