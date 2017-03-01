package easy;

import java.util.Stack;

/**
 * Created by novas on 2016/10/17.
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args)
    {
        TreeNode node1=new TreeNode(0);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        TreeNode node10=new TreeNode(10);
        TreeNode node11=new TreeNode(11);

      //  node1.left=node2;
      //  node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node3.left=node6;
        node3.right=node7;

        node4.left=node8;

        node5.left=node10;

        node8.left=node9;

        node7.right=node11;

        System.out.println(hasPathSum(node1));
    }
    public static int hasPathSum(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode last=null;
        TreeNode p=root;
        int pathsum=0;
        int min=Integer.MAX_VALUE;
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                pathsum=pathsum+1;
                p=p.left;
            }
            p=stack.peek();
            if(p.right==last)
            {
                last=p;
                if(p.left==null&&p.right==null)
                {
                    if(pathsum<min)
                    {
                        min=pathsum;
                    }
                }
                pathsum=pathsum-1;
                stack.pop();
                //  System.out.println(p.val);
                p=null;
            }
            else
            {
                if(p.right!=null)
                {
                    p=p.right;
                }
                else
                {
                    last=p;
                    stack.pop();
                    if(p.left==null&&p.right==null)
                    {
                        if(pathsum<min)
                        {
                            min=pathsum;
                        }                    }
                    pathsum=pathsum-1;
                    // System.out.println(p.val);
                    p=null;
                }
            }
        }
        if(min==Integer.MAX_VALUE)
            min=0;
        return min;
    }
}
