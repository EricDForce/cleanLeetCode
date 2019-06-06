import java.util.HashMap;

/**
 * Created by dengli on 2018/12/31.
 */
public class firstMissingPositive {

    public static void main(String[] argv) {
        int[] nums = {1, 1};
        System.out.println(new firstMissingPositive().firstMissingPositive2(nums));
    }
    //O(n)的时间复杂度，O(n)的空间复杂度
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> isExsit = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!isExsit.containsKey(nums[i])) {
                isExsit.put(nums[i], 1);
            }
        }

        for (int i=1; i<=(nums.length+1); i++) {
            if (!isExsit.containsKey(i)) {
                return i;
            }
        }
        return 1;
    }

    //O(n)的时间复杂度，O(1)的空间复杂度
    public int firstMissingPositive2(int[] nums) {
        int head = 0, tail = nums.length-1;
        while (head < tail) {
            while (tail > 0 && nums[tail] <= 0) {
                tail--;
            }
            while (head < tail && nums[head] > 0) {
                head++;
            }
            if (head < tail) {
                swap(nums, head, tail);
            }
        }
        for (int i=0; i<=tail; i++) {
            //System.out.println("i:" + i);
            //System.out.println("nums[i]" + nums[i]);
            if (nums[i] <= 0 || nums[i]==(i+1) || nums[i] > (tail+1)) {
                continue;
            } else {
                //避免出现{1, 1}的情况造成死循环
                if (nums[i] != nums[nums[i]-1]) {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }

        for (int i=0; i<=tail; i++) {
            if (nums[i] != (i+1)) {
                return (i+1);
            }
        }
        return tail+2;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
