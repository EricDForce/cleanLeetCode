import java.util.PriorityQueue;

/**
 * Created by eric-d on 2017/6/15.
 */
public class JustForTest {
    public static void main(String[] args){
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(100);
        while (queue.size() > 0) {
            queue.offer(index++);
            while (queue.size() >= 4){
                int t = queue.poll();
                System.out.println("t: "+ t);
            }
            if (index == 20)
                break;
        }
    }
}
