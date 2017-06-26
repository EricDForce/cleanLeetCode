/**
 * Created by eric-d on 2017/6/25.
 */
public class MaximumSubarray {
    public static void main(String[] args)
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int f = nums[0], max = nums[0];
        for (int i=1;i<nums.length;i++)
        {
            f = Math.max(f+nums[i], nums[i]);
            max = Math.max(max, f);
        }
        return max;
    }
}
