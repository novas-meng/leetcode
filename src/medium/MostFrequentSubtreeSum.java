package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by novas on 2017/2/27.
 */
public class MostFrequentSubtreeSum {
    public static void main(String[] args)
    {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node4.right=node7;
        node7.left=node8;
        node7.right=node9;
        findFrequentTreeSum(node1);

    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode lastprint=null;
        HashMap<Integer,Integer> map=new HashMap<>();
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                p=p.left;
            }
            p=stack.peek();
            if(p.right==lastprint||p.right==null)
            {
                stack.pop();
                if(stack.isEmpty())
                {
                    if(map.containsKey(p.val))
                    {
                        map.put(p.val,map.get(p.val)+1);
                    }
                    else
                    {
                        map.put(p.val,1);
                    }
                  //  System.out.println(p.val);
                }
                else
                {
                    stack.peek().val+=p.val;
                    if(map.containsKey(p.val))
                    {
                        map.put(p.val,map.get(p.val)+1);
                    }
                    else
                    {
                        map.put(p.val,1);
                    }
                  //  System.out.println(p.val+","+stack.peek().val);
                }
                lastprint=p;
                p=null;
            }
            else
            {
                p=p.right;
            }
        }
        int maxcount=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>maxcount)
            {
                maxcount=entry.getValue();
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==maxcount)
            {
                list.add(entry.getKey());
            }
        }
        int[] res=new int[list.size()];
        for (int i=0;i<res.length;i++)
        {
            res[i]=list.get(i);
        }
        return res;
    }

}
