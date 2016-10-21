import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by novas on 2016/10/12.
 * 树的遍历,后序版本非递归遍历
 */
public class TreeTravel {
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
        TreeNode node10=new TreeNode(10);
        TreeNode node11=new TreeNode(11);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node3.left=node6;
        node3.right=node7;

        node4.left=node8;

        node5.left=node10;

        node8.left=node9;

        node7.right=node11;

        stackPostTravel(node1);
    }
    public static void stackPostTravel(TreeNode root)
    {
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
        for(int i=0;i<pathSumList.size();i++)
        {
            System.out.println(pathSumList.get(i));
        }
    }
    /*
    public static String getStackString(Stack<TreeNode> stack)
    {
        StringBuilder sb=new StringBuilder();
        Iterator<TreeNode> iterator=stack.iterator();
        while (iterator.hasNext())
        {
            sb.append(iterator.next().val+"->");
        }
        return sb.toString().substring(0,sb.toString().length()-2);
    }

    public static void stackPostTravel(TreeNode root)
    {
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
                System.out.println(p.val);
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
                    System.out.println(p.val);
                    last=p;
                    p=null;
                }
                else
                {
                    p=p.right;
                }
            }
        }
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    */
}
