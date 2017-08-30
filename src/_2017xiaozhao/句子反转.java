package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/26.
 */
public class ¾ä×Ó·´×ª {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(var[var.length-1]);
            for (int i=var.length-2;i>=0;i--)
            {
                stringBuilder.append(" "+var[i]);
            }
            System.out.println(stringBuilder.toString());
        }
    }

}
