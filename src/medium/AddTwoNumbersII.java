package medium;

/**
 * Created by novas on 2017/3/5.
 */
public class AddTwoNumbersII {
    public static void main(String[] args)
    {
       ListNode listNode1=new ListNode(9);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(3);
        ListNode listNode5=new ListNode(9);
        ListNode listNode6=new ListNode(9);
        ListNode listNode7=new ListNode(9);
        ListNode listNode8=new ListNode(7);

       // listNode1.next=listNode2;
        //listNode2.next=listNode3;
        //listNode3.next=listNode4;

        listNode5.next=listNode6;
        listNode6.next=listNode7;
       // listNode7.next=listNode8;
        addTwoNumbers(listNode1,listNode5);

    }
    public static int  getLength(ListNode head)
    {
        int count=0;
        ListNode p=head;
        while (p!=null)
        {
            count++;
            p=p.next;
        }
        return count;
    }
    public static ListNode[] add(ListNode l1,ListNode l2,int l)
    {
        ListNode p=l1.next;
        int count=0;
        ListNode result=new ListNode(-1);
        ListNode p_result=result;
        while (count<l)
        {
            p_result.next=p;
            p_result=p_result.next;
            p=p.next;
            count++;
        }
      //  System.out.println("P=" + p.val);
        ListNode jinwei=new ListNode(-1);
        ListNode p_jinwei=jinwei;
        ListNode q=l2.next;
        while (p!=null)
        {
            int sum=p.val+q.val;
           // System.out.println("sum="+sum);
            ListNode listNode=new ListNode(sum%10);
            p_result.next=listNode;
            p_result=p_result.next;
            ListNode listNode1=new ListNode(sum/10);
            p_jinwei.next=listNode1;
            p_jinwei=p_jinwei.next;
            p=p.next;
            q=q.next;
        }
       // if(getLength(jinwei)==2&&jinwei.next.val==0)
      //  {

       // }
       // else
       // {
        ListNode listNode1=new ListNode(0);
        p_jinwei.next=listNode1;
        p_jinwei=p_jinwei.next;

         p=jinwei.next;
        while (p.val==0&&p.next!=null)
        {
            p=p.next;
        }
        jinwei.next=p;


      //  }
        ListNode[] listNodes=new ListNode[2];
        listNodes[0]=result;
        listNodes[1]=jinwei;
      //  System.out.println(listNodes[0].val);
        return listNodes;
    }
    public static void Travel(ListNode p)
    {
        ListNode l=p;
        System.out.println("=========");
        while (l!=null)
        {
            System.out.println(l.val);
            l=l.next;
        }
    }
    public static ListNode[] addTwo(ListNode l1,ListNode l2)
    {
        int l1_length=getLength(l1);
        int l2_length=getLength(l2);
        ListNode[] listNodes=null;
        if(l1_length>=l2_length)
        {
            listNodes=add(l1,l2,l1_length-l2_length);
        }
        else
        {
            listNodes=add(l2,l1,l2_length-l1_length);
        }
        return listNodes;
    }
    public static int sum(ListNode p)
    {
        int sum=0;
        ListNode l=p.next;
        while (l!=null)
        {
            sum=sum+l.val;
            l=l.next;
        }
        return sum;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1_head=new ListNode(-1);
        l1_head.next=l1;
        ListNode l2_head=new ListNode(-1);
        l2_head.next=l2;
        int sum=1;
        ListNode[] listNodes=new ListNode[2];
        listNodes[0]=l1_head;
        listNodes[1]=l2_head;
        while (sum!=0)
        {
            listNodes=addTwo(listNodes[0],listNodes[1]);
            sum=sum(listNodes[1]);
            Travel(listNodes[0]);
            Travel(listNodes[1]);
        }

       // listNodes=addTwo(listNodes[0],listNodes[1]);
       // Travel(listNodes[0]);
       // Travel(listNodes[1]);

       // listNodes=addTwo(listNodes[0],listNodes[1]);
       // Travel(listNodes[0]);
      //  Travel(listNodes[1]);

        ListNode p=listNodes[0].next;
        while (p.val==0&&p.next!=null)
        {
            p=p.next;
        }
        Travel(p);
       // Travel(listNodes[1]);
        return p;
    }

}
