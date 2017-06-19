import java.util.PriorityQueue;

/**
 * Created by eric-d on 2017/6/15.
 */
public class JustForTest {
    public static void main(String[] args){
        String str = "dengli";
        System.out.println("output: " + str);
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("dengli");
        queue.offer("bowen");
        queue.offer("chencheng");
        queue.offer("lilianjie");
        while (queue.size() > 0) {
            String st = queue.poll();
            System.out.println("string: " + st);
        }
    }
}
