import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class didi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strList = sc.nextLine().split(" ");
        int k =sc.nextInt();
        int[] nums = new int[strList.length];
        for (int i=0;i<strList.length;i++) {
            nums[i] = Integer.parseInt(strList[i]);
        }
        PriorityQueue<Integer> result = new didi2().topK(nums, k);
        System.out.println(result.poll());
    }

    public PriorityQueue<Integer> topK(int[] nums, int k) {
        PriorityQueue<Integer> result = new PriorityQueue<Integer>();
        for (int i=0; i<nums.length; i++) {
            result.offer(nums[i]);
            if (result.size() > k) {
                result.poll();
            }
        }
        return result;
    }
}
