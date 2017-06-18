import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by eric-d on 2017/2/13.
 */

public class InsertionSortList {

    public static void main(String[] args){
        reverselist.ListNode head = new reverselist().new ListNode(4);
        reverselist.ListNode head1 = new reverselist().new ListNode(2);
        reverselist.ListNode head2 = new reverselist().new ListNode(1);
        reverselist.ListNode head3 = new reverselist().new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;

        reverselist.ListNode ptr = new InsertionSortList().insertionSortList2(head);;
        while (ptr != null){
            System.out.println(ptr.val + " ");
            ptr = ptr.next;
        }
    }
    public reverselist.ListNode insertionSortList2(reverselist.ListNode head) {
        reverselist.ListNode ptr = head;
        reverselist.ListNode res = new reverselist().new ListNode(0);
        res.next = head;
        if (head.next == null)
            return head;
        reverselist.ListNode right = head.next;
        reverselist.ListNode tmp1, tmp;
        head.next = null;

        while (right != null){
            tmp = right.next;
            ptr = res;
//            if (right.val < head.val){
//                right.next = head;
//                head = right;
//                right = tmp;
//                continue;
//            }
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
