package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by novas on 2017/2/25.
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        root.left=left;
        root.right=right;

        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);


        left.left=node4;
        right.left=node5;
        right.right=node6;
        node5.left=node7;
        System.out.println(findBottomLeftValue(root));
    }
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        queue.add(root);
        int mostleft=root.val;
        int last=root.val;
        while (true)
        {
            while (!queue.isEmpty())
            {
                TreeNode p=queue.poll();
                if(p.left!=null)
                {
                    treeNodeQueue.add(p.left);
                    if(mostleft==root.val)
                    mostleft=p.left.val;
                }
                if(p.right!=null)
                {
                    treeNodeQueue.add(p.right);
                    if(mostleft==root.val)
                        mostleft=p.right.val;
                }
            }
            if(treeNodeQueue.isEmpty())
            {
                return last;
            }
            queue.clear();
            queue.addAll(treeNodeQueue);
            treeNodeQueue.clear();
            last=mostleft;
            mostleft=root.val;

        }
    }
}
