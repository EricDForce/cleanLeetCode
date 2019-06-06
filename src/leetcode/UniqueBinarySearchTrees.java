/**
 * Created by eric-d on 2017/6/28.
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args)
    {
        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
    }
    public int numTrees(int n) {
        if(n==0){
            return 0;
        }
        int[] dp = new int[n+10];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
