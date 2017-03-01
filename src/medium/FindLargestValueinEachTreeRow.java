package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by novas on 2017/2/26.
 */
public class FindLargestValueinEachTreeRow {
    public static void main(String[] args)
    {


    }
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        list.add(root.val);
        int max=Integer.MAX_VALUE;
        while (true) {
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    treeNodeQueue.add(p.left);
                    if(p.left.val>max)
                    {
                        max=p.left.val;
                    }
                }
                if (p.right != null) {
                    treeNodeQueue.add(p.right);
                    if(p.right.val>max)
                    {
                        max=p.right.val;
                    }
                }
            }
            if (treeNodeQueue.isEmpty()) {
                return list;
            }
            list.add(max);
            max=Integer.MIN_VALUE;
            queue.clear();
            queue.addAll(treeNodeQueue);
            treeNodeQueue.clear();
        }
    }

}
