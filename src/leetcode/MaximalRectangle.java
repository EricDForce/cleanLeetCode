import java.util.Stack;

/**
 * Created by eric-d on 2017/6/26.
 */
public class MaximalRectangle {
    public static void main(String[] args)
    {
        char[][] nums = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(nums));
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[] heights = new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                heights[j] = (matrix[i][j]=='0') ? 0 : heights[j]+1;
            }
            max = Math.max(new LargestRectangleinHistogram().largestRectangleArea(heights), max);
        }
        return max;
    }
}
