import java.util.*;

public class dataMedian {
    public static PriorityQueue<Integer> min = new PriorityQueue();
//    PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
    //当JDK8的时候，可以直接写成，不再需要初始化容量
    //数据流取中位数，插入O(lgn),取中位数O(1)
    public static PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
    public static void main(String[] args){
        Integer[] nums = {1,2,5,7,9,8,4,5};
        for (int i=0; i<nums.length; i++){
            new dataMedian().Insert(nums[i]);
        }
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(min);
        System.out.println(max);
        System.out.println(new dataMedian().GetMedian());
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void Insert(Integer num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek())/2.0;
        }
        return (double)max.peek();
    }
}
