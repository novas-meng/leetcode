package easy;

import java.util.ArrayList;

/**
 * Created by novas on 2017/2/25.
 */
public class IntersectionofTwoLinkedLists {
     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                     val = x;
                     next = null;
                 }
         }
    public static void main(String[] args)
    {

    }
    public ListNode run(ListNode A,ListNode B,int firstrun)
    {
        int count=0;
        ListNode p=A;
        while (count<firstrun)
        {
            p=p.next;
            count++;
        }
        ListNode q=B;
        while (p!=q)
        {
            p.next=q.next;
        }
        return p;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int lengthA=0;
        ListNode p=headA;
        while (p!=null)
        {
            lengthA++;
            p=p.next;
        }
        int lengthB=0;
        p=headB;
        while (p!=null)
        {
            lengthB++;
            p=p.next;
        }
        if(lengthA>lengthB)
        {
            return run(headA,headB,lengthA-lengthB);
        }
        else
        {
            return run(headB,headA,lengthB-lengthA);
        }
    }

}
