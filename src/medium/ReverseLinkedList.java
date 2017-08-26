package medium;

/**
 * Created by novas on 2017/3/10.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode p_head=new ListNode(-1);
        ListNode p=head;
        if(p==null)
            return null;
        while (p!=null)
        {
            ListNode q=p.next;
            p.next=p_head.next;
            p_head.next=p;
            p=q;
        }
        return p_head.next;
    }
}
