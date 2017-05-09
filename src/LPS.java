import java.util.Arrays;

/**
 * Created by eric-d on 2017/4/11.
 */
public class LPS {
    public static void main(String[] args){
        String s = "babad";
        char[] s2c = s.toCharArray();
        Arrays.sort(s2c);
        String t = String.valueOf(s2c);
        System.out.println("---:" + t);
        System.out.println(new LPS().longestPalindrome2(s));
    }
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 1; i < s.length(); i++){
            dp[i][i] = true;
            if (s.charAt(i-1) == s.charAt(i)) dp[i][i+1] = true;
        }
        int maxlen = 0;
        String result = "";
        for (int i = 0; i < s.length()-1; i++){
            for (int j=i+2; j < s.length(); j++){
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i+1)==s.charAt(j-1));
                if (dp[i][j] && (j-i)>maxlen){
                    maxlen = j - i + 1;
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

    public String longestPalindrome2(String s){
        int start = 0, end = 0;
        int maxlen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++){
            int len1 = extendAroundCenter(s, i, i);
            int len2 = extendAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int extendAroundCenter(String s, int left , int right){
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
