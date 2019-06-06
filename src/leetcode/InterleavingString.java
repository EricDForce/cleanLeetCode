/**
 * Created by eric-d on 2017/6/28.
 */
public class InterleavingString {
    public static void main(String[] args)
    {
        boolean[] dp = new boolean[3];
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        if (l1+l2 != l3){
            return false;
        }

        for (int i=0;i<=l1;i++){
            for (int j=0;j<=l2;j++){
                if (i==0&&j==0){
                    continue;
                }
                if (i==0){
                    dp[i][j] = dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(j-1));
                    continue;
                }
                if (j==0){
                    dp[i][j] = dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i-1));
                    continue;
                }
                dp[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1))&&(dp[i-1][j]) ||
                        (s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]);
            }
        }
        return dp[l1][l2];
    }
}
