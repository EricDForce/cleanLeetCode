import java.util.Scanner;

public class WAP {

    private static final int maxn = 1000 + 5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int w[] = new int[maxn];
        int a[] = new int[maxn];
        int b[] = new int[maxn];
        for(int i = 0;i<n;i++) {
            w[i] = in.nextInt();
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        System.out.println(getMax(n, m, w, a, b));
    }
    public static int getMax(int n, int m, int[] w, int[] a, int[] b) {
        int[][] dp = new int[maxn][maxn];
        int[][] nums = new int[m][n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = w[i]; j < m; ++j) {
                int tmp = dp[j - w[i]][i] + (nums[j - w[i]][i] == 0 ? (a[i] + b[i]) : a[i]);
                if (dp[j][i] >= tmp) {
//                    nums[j][i] = nums[j - w[i]][i];
                } else {
                    dp[j][i] = tmp;
                    nums[j - w[i]][i] ++;
                }
                max = Math.max(max, dp[j][i]);
            }
        }
        return max;
    }
}
