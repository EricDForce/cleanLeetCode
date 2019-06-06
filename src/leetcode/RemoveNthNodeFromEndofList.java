public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode nodeHead = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        nodeHead.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode result = new RemoveNthNodeFromEndofList().removeNthFromEnd(nodeHead, 2);
        while (result != null) {
            System.out.println("the value is %d"+result.val);
            result = result.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode ptr = head;
        while(ptr != null) {
            cnt += 1;
            ptr = ptr.next;
        }
        //如果n的长度等于链表的长度，则要单独考虑
        int ll = n%cnt==0 ? 0 : (cnt-n%cnt);
        ptr = head;
        cnt = 0;
        if (cnt == ll) return head.next;
        while(ptr != null) {
            cnt += 1;
            if (cnt == ll) {
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }
        return head;
    }
}
