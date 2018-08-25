public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode tail = head;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                ListNode tmp = p1.next;
                p1.next = tail.next;
                tail.next = p1;
                p1 = tmp;
            }else {
                ListNode tmp = p2.next;
                p2.next = tail.next;
                tail.next = p2;
                p2 = tmp;
            }
            tail = tail.next;
        }

        while(p1 != null){
            ListNode tmp = p1.next;
            p1.next = tail.next;
            tail.next = p1;
            p1 = tmp;
            tail = tail.next;
        }

        while(p2 != null){
            ListNode tmp = p2.next;
            p2.next = tail.next;
            tail.next = p2;
            p2 = tmp;
            tail = tail.next;
        }
        return head.next;
    }
}