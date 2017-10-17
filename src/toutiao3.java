import java.util.Scanner;

public class toutiao3 {
    public static void main(String[] args){
        int[] nums = {1, -2, 3, 5, 6, 7, 8, -1, 2};
        System.out.println(getNums(nums));
    }
    public static int getNums(int[] nums){
        int[] dp = new int[nums.length];
        boolean[] bool = new boolean[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0], dp[1]);
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(Math.max(dp[i-2]+nums[i], dp[i-1]), nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
