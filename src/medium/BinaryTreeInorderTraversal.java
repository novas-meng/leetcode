package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by novas on 2017/3/14.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode p=root;
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                p=p.left;
            }
            TreeNode treeNode=stack.pop();
            list.add(treeNode.val);
            if(treeNode.right!=null)
            {
                p=treeNode.right;
            }
        }
        return list;
    }
}
