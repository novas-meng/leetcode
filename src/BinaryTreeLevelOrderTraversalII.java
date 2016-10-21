import java.util.*;

/**
 * Created by novas on 2016/10/13.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<List<Integer>> stack=new LinkedList<>();
        if(root!=null)
        queue.add(root);
        while (!queue.isEmpty())
        {
            Queue<TreeNode> childqueue=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            while (!queue.isEmpty())
            {
                TreeNode p=queue.poll();
                list.add(p.val);
                if(p.left!=null)
                {
                    childqueue.add(p.left);
                }
                if(p.right!=null)
                {
                    childqueue.add(p.right);
                }
            }
            stack.add(list);
            queue=childqueue;
        }
        while (!stack.isEmpty())
        {
            res.add(stack.poll());
        }
        return res;
    }
}
