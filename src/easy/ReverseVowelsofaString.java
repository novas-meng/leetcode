package easy;

import java.util.ArrayList;

/**
 * Created by novas on 2016/11/17.
 */
public class ReverseVowelsofaString {
    public static void main(String[] args)
    {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        ArrayList<Character> list=new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        char[] array=s.toCharArray();
        int i=0;
        int j=array.length-1;
        while (i<j)
        {
            if(!list.contains(array[i]))
            {
                i++;
            }
            if(!list.contains(array[j]))
            {
                j--;
            }
            if(list.contains(array[i])&&list.contains(array[j]))
            {
                char temp=array[j];
                array[j]=array[i];
                array[i]=temp;
                i++;
                j--;
            }
        }
        return new String(array);
    }
}
