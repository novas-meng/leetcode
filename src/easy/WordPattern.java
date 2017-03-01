package easy;

import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by novas on 2016/10/24.
 */
public class WordPattern {
    public String getKey(Object[] objects)
    {
        ArrayList list=new ArrayList();
        for (int i=0;i<objects.length;i++)
        {
           if(!list.contains(objects[i]))
           {
              list.add(objects[i]);
           }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<objects.length;i++)
        {
            sb.append(list.indexOf(objects[i]));
        }
        return sb.toString();
    }
    public boolean wordPattern(String pattern, String str) {
        char[] array=pattern.toCharArray();
        Character[] aarray=new Character[array.length];
        for (int i=0;i<array.length;i++)
        {
            aarray[i]=array[i];
        }
        String[] barray=str.split(" ");
       return getKey(aarray).equals(getKey(barray));
    }

}
