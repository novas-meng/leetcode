package easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by novas on 2016/10/12.
 */

public class SymmetricTree {
    public static void main(String[] args)
    {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(2);
node1.left=node2;
        node1.right=node3;
        System.out.println(isSymmetric(node1));

    }
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Queue<TreeNode> childqueue=new LinkedList<>();
            while (!queue.isEmpty())
            {
                TreeNode p=queue.poll();
                if(p!=null)
                {
                    childqueue.add(p.left);
                    childqueue.add(p.right);
                }
            }
            ArrayList<TreeNode> list=new ArrayList<>();
            Iterator<TreeNode> iterator=childqueue.iterator();
            while (iterator.hasNext())
            {
                list.add(iterator.next());
            }
            int i=0;
            int j=list.size()-1;
            while (j>i)
            {
                if(list.get(i)==null&&list.get(j)!=null)
                {
                    return false;
                }
                if(list.get(j)==null&&list.get(i)!=null)
                {
                    return false;
                }
                if(list.get(i)!=null&&list.get(j)!=null&&list.get(i).val!=list.get(j).val)
                {
                    return false;
                }
                i++;
                j--;
            }
            queue=childqueue;
        }
        return true;
    }
}
