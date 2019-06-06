import java.util.ArrayList;
import java.util.*;
import java.util.Map;

/**
 * Created by eric-d on 2017/2/11.
 */
public class detectCycle {
    public static void main(String[] args){
        String test = "nihao,qiaoan";
        System.out.println("test : " + test);
    }
    public ListNode detectCycle2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null){
            if (list.contains(ptr))
                return ptr;
            list.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }
}
