import java.util.Stack;

/**
 * Created by eric-d on 2017/6/27.
 */
public class MaximalSquare {
    public int maximalSquareforshort(char[][] matrix) {  //dp[i][j]表示以（i， j）为右下角的正方形的边长
        if(matrix.length<=0 || matrix[0].length<=0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] heights = new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                heights[j] = (matrix[i][j]=='0') ? 0 : heights[j]+1;
            }
            max = Math.max(largestRectangleArea(heights), max);
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i=0, max_area=0, tp=0, area=0;
        while (i<heights.length)
        {
            if (stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }else {
                tp = stack.pop();
                int tmp = Math.min(heights[tp], (stack.empty() ? i : i-stack.peek()-1));
                area = tmp * tmp;
                if (area>max_area){
                    max_area = area;
                }
            }
        }
        while (!stack.isEmpty())
        {
            tp = stack.pop();
            int tmp = Math.min(heights[tp], (stack.empty() ? i : i-stack.peek()-1));
            area = tmp * tmp;
            if (area>max_area){
                max_area = area;
            }
        }
        return max_area;
    }
}
