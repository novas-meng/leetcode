package easy;

/**
 * Created by novas on 2016/10/19.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newhead=new ListNode(-1);
        newhead.next=head;
        int count=0;
        ListNode p=newhead.next;
        while (p!=null)
        {
            count++;
            p=p.next;
        }
        int index=count-n+1;
        p=newhead.next;
        count=1;
        ListNode q=newhead;
        while (count<index)
        {
            q=p;
            p=p.next;
            count++;
        }
        q.next=p.next;
        return newhead.next;
    }
}
