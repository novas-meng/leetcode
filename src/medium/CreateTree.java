package medium;

/**
 * Created by novas on 2017/4/16.
 */
public class CreateTree {
    static int count=0;
    public static TreeNode create(int[] pre,int[] in ,int begin,int end)
    {
        int index=-1;
        for(int i=begin;i<=end;i++)
        {
            if(in[i]==pre[count])
            {
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(pre[count]);
        TreeNode left=null;
        TreeNode right=null;
        count=count+1;
        if(begin<=index-1)
        {
            left=create(pre,in,begin,index-1);
            System.out.println("left "+root.val+","+left.val);
        }
        if(index+1<=end)
        {
            right=create(pre,in,index+1,end);
            System.out.println(root.val+","+right.val);
        }
        root.left=left;
        root.right=right;
        return root;
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return create(pre,in,0,pre.length-1);
    }
    public static void main(String[] args)
    {
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        reConstructBinaryTree(pre,in);
    }

}
