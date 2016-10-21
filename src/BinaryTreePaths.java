import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by novas on 2016/10/16.
 */
public class BinaryTreePaths {
    public  String getStackString(Stack<TreeNode> stack)
    {
        StringBuilder sb=new StringBuilder();
        Iterator<TreeNode> iterator=stack.iterator();
        while (iterator.hasNext())
        {
            sb.append(iterator.next().val+"->");
        }
        return sb.toString().substring(0,sb.toString().length()-2);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode last=null;
        TreeNode p=root;
        ArrayList<String> list=new ArrayList<>();
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                p=p.left;
            }
            p=stack.peek();
            if(p.right==last)
            {
                if(p.right==null&&p.left==null) {
                    list.add(getStackString(stack));
                }
                stack.pop();
                last=p;
                p=null;
            }
            else
            {
                if(p.right==null)
                {
                    if(p.right==null&&p.left==null) {
                        list.add(getStackString(stack));
                    }
                    stack.pop();
                    last=p;
                    p=null;
                }
                else
                {
                    p=p.right;
                }
            }
        }
        return list;
    }
}
