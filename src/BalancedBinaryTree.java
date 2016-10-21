import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by novas on 2016/10/12.
 * 判断一个树是否是平衡二叉树
 */
//后序遍历

public class BalancedBinaryTree {
   public static boolean BalancedBinaryTree(TreeNode root)
   {
       HashMap<TreeNode,Integer> map=new HashMap<>();
       map.put(null,0);
       TreeNode p=root;
       Stack<TreeNode> stack=new Stack<TreeNode>();
       //用child保存上一个输出元素
       TreeNode child=null;
       //判断终止条件
       while(!stack.isEmpty()||p!=null)
       {
           //将节点的左子树全部进入堆栈
           while(p!=null)
           {
               stack.add(p);
               p=p.left;
           }
           //查看栈顶元素
           p=stack.peek();
           //判断栈顶元素的右子树是否是之前输出的元素，如果是，直接pop
           if(p.right==child)
           {
               stack.pop();
               TreeNode d=p;
               int left=map.get(d.left);
               int right=map.get(d.right);
               if(Math.abs(left-right)>1)
               {
                   return false;
               }
               map.put(d,Math.max(left,right)+1);
               child=p;
               p=null;
           }
           else
           {
               //如果不是之前输出的元素，而且右子树为空，直接pop，进入下次循环，从这里可以看出来，下次循环，直接也是进行查看栈顶元素的操作
               if(p.right==null)
               {
                   child=p;
                   stack.pop();
                   TreeNode d=p;
                   int left=map.get(d.left);
                   int right=map.get(d.right);
                   if(Math.abs(left-right)>1)
                   {
                       return false;
                   }
                   map.put(d, Math.max(left, right) + 1);
                   p=null;
               }
               //右子树不空，指针指向右子树
               else
               {
                   p=p.right;
               }
           }

       }
       return true;
   }

}
