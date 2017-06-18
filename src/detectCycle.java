import java.util.ArrayList;
import java.util.*;
import java.util.Map;

/**
 * Created by eric-d on 2017/2/11.
 */
public class detectCycle {

//    public Solution.ListNode detectCycle3(Solution.ListNode head){
//
//    }
    public Solution.ListNode detectCycle2(Solution.ListNode head){
        List<Solution.ListNode> list = new ArrayList<>();
        Solution.ListNode ptr = head;
        while (ptr != null){
            if (list.contains(ptr)){
                return ptr;
            }
            list.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }
}
