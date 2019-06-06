/**
 * Created by dengli on 2018/11/18.
 */
public class ArraySort implements Runnable {
    public String num;

    public ArraySort(int num) {
        this.num = num + "";
    }

    public static void main(String[] args) {
        int[] nums = {11, 3, 998, 5455, 1, 152, 998};
        for (int i = 0; i < nums.length; i++) {
            new Thread(new ArraySort(nums[i])).start();
        }
    }

    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
