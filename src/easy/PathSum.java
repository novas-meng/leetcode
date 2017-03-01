package easy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by novas on 2016/10/17.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode last=null;
        TreeNode p=root;
        ArrayList<Integer> pathSumList=new ArrayList<>();
        int pathsum=0;
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                pathsum=pathsum+p.val;
                p=p.left;
            }
            p=stack.peek();
            if(p.right==last)
            {
                last=p;
                if(p.left==null&&p.right==null)
                {
                    pathSumList.add(pathsum);
                }
                pathsum=pathsum-p.val;
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
                        pathSumList.add(pathsum);
                    }
                    pathsum=pathsum-p.val;
                    // System.out.println(p.val);
                    p=null;
                }
            }
        }
        return pathSumList.contains(sum);
    }
}
