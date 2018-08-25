import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 2016/12/13.
 */
public class reverselist {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args){
        int maxLen = 100;
        String str = new String("dengli");
        List<Integer> array = new ArrayList<>();
        for (int i=0; i<maxLen; i++){
            if (i>10){
                System.out.println("i :" + i);
            }
        }
    }
}
