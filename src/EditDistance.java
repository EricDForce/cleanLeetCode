/**
 * Created by eric-d on 2017/6/26.
 */
public class EditDistance {
    public static void main(String[] args)
    {
        String word1 = "saprr", word2 = "wap";
        System.out.println(new EditDistance().minDistance(word1, word2));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        for (int j=0;j<=n;j++){
            dp[0][j] = j;
        }
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++){
                int t1 = (word1.charAt(i-1)==word2.charAt(j-1)) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                int t2 = dp[i-1][j] + 1;
                int t3 = dp[i][j-1] + 1;
                dp[i][j] = Math.min(Math.min(t1, t2), t3);
            }
        }
        return dp[m][n];
    }
}
