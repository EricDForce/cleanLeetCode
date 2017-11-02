/**
 * Created by eric-d on 2017/6/27.
 */
public class DecodeWays {
    public static void main(String[] args) {
        String s = "12120";
        System.out.println(new DecodeWays().numDecodings(s));
    }
    public int numDecodings(String s) {
        int l = s.length();
        int[] dp = new int[l+1];
        if(l<=0){
            return 0;
        }
        dp[0]=1;
        for(int i=1;i<=l;i++){
            dp[i] = (s.charAt(i-1)=='0') ? 0 : dp[i-1];
            if (i>=2) {
                int tmp = Integer.parseInt(s.substring(i - 2, i));
                if (tmp <= 26 && tmp >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[l];
    }
}
