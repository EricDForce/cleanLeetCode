/**
 * Created by eric-d on 2017/6/26.
 */
public class MinimumPathSum {
    public static void main(String[] args)
    {
        int[][] nums = {{1,2},{1,1}};
        System.out.println(new MinimumPathSum().minPathSum(nums));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m<=0 || n<=0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0&&j==0)
                    continue;
                if (i==0&&j>=1){
                    dp[j] = dp[j-1]+grid[i][j];
                    continue;
                }
                if (i>=1&&j==0){
                    dp[j] += grid[i][j];
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
