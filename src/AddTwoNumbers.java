import java.util.List;

/**
 * Created by eric-d on 2017/6/23.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode p1 = l1, p2 = l2;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        int tmp = 0, left = 0, right = 0;

        while (p1 != null && p2 != null) {
            tmp = (p1.val+p2.val+right);
            left = tmp % 10;
            right = tmp / 10;
            ListNode t = new ListNode(left);
            p.next = t;
            p = t;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            tmp = (p1.val+right);
            left = tmp % 10;
            right = tmp / 10;
            ListNode t = new ListNode(left);
            p.next = t;
            p = t;
            p1 = p1.next;
        }

        while (p2 != null)
        {
            tmp = (p2.val+right);
            left = tmp % 10;
            right = tmp / 10;
            ListNode t = new ListNode(left);
            p.next = t;
            p = t;
            p2 = p2.next;
        }

        if (right != 0){
            ListNode t = new ListNode(right);
            p.next = t;
            p = t;
            p.next = null;
        }
        return result.next;
    }
}
