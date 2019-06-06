/**
 * Created by eric-d on 2017/6/26.
 */
public class UniquePaths {
    public static void main(String[] args)
    {
        int[][] nums = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new UniquePaths().uniquePathsWithObstacles(nums));
    }
    public int uniquePaths(int m, int n)
    {
        if (m<=0 || n<=0)
        {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        if (m<=0||n<=0)
            return 0;
        int[] dp = new int[n+1];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if ((i==0 && j==0)||(obstacleGrid[i][j] == 1)) {
                    dp[j + 1] = 1 - obstacleGrid[i][j];
                    continue;
                }
                dp[j+1] = dp[j+1] + dp[j];
            }
        }
        return dp[n];
    }
}
