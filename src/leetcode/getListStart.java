public class getListStart {
    public ListNode getListCircleStart(ListNode head){
        ListNode p1 = head, p2 = head;
        int cnt = 0;
        while (p2 !=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1==p2){
                ListNode p3 = p2.next;
                while (p3 != p2){
                    cnt++;
                    p3 = p3.next;
                }
                break;
            }
        }
        if (p2 == null || p2.next == null){
            System.out.println("there is no circle");
            return null;
        }
        p1 = head;
        p2 = head;
        int count = 0;
        while (true){
            if (count != cnt) {
                count++;
                p1 = p1.next;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1 == p2){
                break;
            }
        }
        return p1;
    }
}
