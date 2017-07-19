import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by eric-d on 2017/2/13.
 */

public class InsertionSortList {

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;

        ListNode ptr = new InsertionSortList().insertionSortList2(head);;
        while (ptr != null){
            System.out.println(ptr.val + " ");
            ptr = ptr.next;
        }
    }
    public ListNode insertionSortList2(ListNode head) {
        ListNode ptr = head;
        ListNode res = new ListNode(0);
        res.next = head;
        if (head.next == null)
            return head;
        ListNode right = head.next;
        ListNode tmp1, tmp;
        head.next = null;

        while (right != null){
            tmp = right.next;
            ptr = res;
            while (ptr != null){
                System.out.println("-----: " + ptr.val);
                tmp1 =ptr.next;
                if((ptr.next == null) || (ptr.next != null && (ptr.val < right.val) && ptr.next.val>right.val)){
                    right.next = ptr.next;
                    ptr.next = right;
                    ptr = tmp1;
                    break;
                }else {
                    ptr = tmp1;
                }
            }
            right = tmp;
        }
        return res.next;
    }
}
