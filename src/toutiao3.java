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
    public static int editDistance(String str1, String str2){
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for (int j=0; j<=n; j++){
            dp[0][j] = j;
        }

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                int t1 = (str1.charAt(i-1)==str2.charAt(j-1)) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                int t2 = dp[i][j-1] + 1;
                int t3 = dp[i-1][j] + 1;
                dp[i][j] = Math.min(Math.min(t1, t2), t3);
            }
        }
        return dp[m][n];
    }
}
