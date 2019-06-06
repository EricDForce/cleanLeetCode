/**
 * Created by dengli on 2018/12/30.
 */
public class partitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode tvsf = first;
        first.next = null;
        ListNode second = new ListNode(1);
        ListNode tvss = second;
        second.next = null;
        ListNode tvs = head;
        while(tvs != null) {
            ListNode tmp = tvs.next;
            if (tvs.val < x) {
                tvs.next = tvsf.next;
                tvsf.next = tvs;
                tvsf = tvsf.next;
            }else {
                tvs.next = tvss.next;
                tvss.next = tvs;
                tvss = tvss.next;
            }
            tvs = tmp;
        }
        tvsf.next = second.next;
        return first.next;
    }
}
