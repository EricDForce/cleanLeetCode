/**
 * Created by eric-d on 16/8/24.
 */
public class leetcode1 {

    public static void main(String[] args){
        leetcode1 t = new leetcode1();
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(t.maxSubArray(array));
    }
    public int maxSubArray(int[] nums){
        int[] sum = new  int[nums.length];
        int result = 0;

        if(nums.length == 0) {
            return 0;
        }
        result = nums[0];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(sum[i-1] + nums[i] <= nums[i]) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i-1] + nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, sum[i]);
        }
        return result;
    }
}
