/**
 * Created by eric-d on 2017/6/29.
 */
public class DistinctSubsequences {
    public static void main(String[] args)
    {
        String s = "ccc", t = "ccc";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 1;
        for (int i=1;i<=l1;i++) {
            for (int j=0;j<=l2;j++) {
                if (j==0) {
                    dp[i][0] = 1;
                    continue;
                }
                dp[i][j] = (s.charAt(i-1)==t.charAt(j-1)) ? (dp[i-1][j]+dp[i-1][j-1]) : dp[i-1][j];
            }
        }
        return dp[l1][l2];
    }
}
