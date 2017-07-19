import java.util.Stack;

/**
 * Created by eric-d on 2017/6/25.
 */
public class LongestValidParentheses {
    public static void main(String[] args)
    {
        String s = "(()())";
        System.out.println(new LongestValidParentheses().longestValidParenthese(s));
    }

    public int longestValidParenthese(String s) {     //DP解法，超时！！！
        int l = s.length();
        int[] dp = new int[l+1];
        int maxLen = dp[0];
        for (int i=0;i<l;i++) {
            if (s.charAt(i) == ')') {
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    dp[i+1] = dp[i - 1] + 2;
                } else if (i - 1 >= 0 && (i - 1 - dp[i])>=0 &&s.charAt(i - 1) == ')' && s.charAt(i - 1 - dp[i]) == '(') {
                    dp[i+1] = dp[i] + 2 + dp[i - 1 - dp[i]];
                }

                maxLen = Math.max(maxLen, dp[i+1]);
            }
        }
        return maxLen;
    }
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }
}
