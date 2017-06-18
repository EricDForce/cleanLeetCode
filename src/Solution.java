import java.util.Scanner;

/**
 * Created by eric-d on 2016/10/29.
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args)
    {
        ListNode t = new Solution().new ListNode(1);
        ListNode t1 = new Solution().new ListNode(4);
        ListNode t2 = new Solution().new ListNode(3);
        ListNode t3 = new Solution().new ListNode(2);
        ListNode t4 = new Solution().new ListNode(5);
        ListNode t5 = new Solution().new ListNode(2);

        t.next = t1;
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

        ListNode res = new Solution().partition(t, 3);

        while(res != null)
        {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        bigHead.next = null;
        newHead.next = null;
        ListNode pos = head;
        ListNode tail = bigHead;
        ListNode tail2 = newHead;
        if(head == null || head.next == null)
            return head;

        while(pos != null)
        {
            if(pos.val < x)
            {
                ListNode tmp = pos.next;
                pos.next = tail2.next;
                tail2.next = pos;
                tail2 = tail2.next;
                pos = tmp;
            }else{
                ListNode tmp = pos.next;
                pos.next = tail.next;
                tail.next = pos;
                tail = tail.next;
                pos = tmp;
            }
        }
        tail2.next = bigHead.next;
        return newHead.next;
    }

}
