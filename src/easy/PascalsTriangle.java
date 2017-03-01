package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by novas on 2016/10/13.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            ArrayList<Integer> newlist=new ArrayList<>();
            for (int j=0;j<=i;j++)
            {
                newlist.add(-1);
            }
            newlist.set(0,1);
            newlist.set(i,1);
            for(int j=1;j<i;j++)
            {
                newlist.set(j,temp.get(j-1)+temp.get(j));
            }
            res.add(newlist);
            temp=newlist;
        }
        return res;
    }
}
