import java.util.PriorityQueue;

/**
 * Created by eric-d on 2017/6/15.
 */
public class JustForTest {
    public static void main(String[] args){
//        int index = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(100);
//        while (queue.size() > 0) {
//            queue.offer(index++);
//            while (queue.size() >= 4){
//                int t = queue.poll();
//                System.out.println("t: "+ t);
//            }
//            if (index == 20)
//                break;
//        }
//        String str = "{0xff, 0xfe}";
//        String[] str2list = str.split("\\{|\\}|\\,\\ ");
//        for (String t : str2list){
//            System.out.println("t : " + t);
//        }
        //定义父类数组
        Wine[] wines = new Wine[2];
        //定义两个子类
        JNC jnc = new JNC();
        JGJ jgj = new JGJ();

        //父类引用子类对象
        wines[0] = jnc;
        wines[1] = jgj;

        for(int i = 0 ; i < 2 ; i++){
            System.out.println(wines[i].toString() + "--" + wines[i].drink());
        }
        System.out.println("-------------------------------");
    }
}
