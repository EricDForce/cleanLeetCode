import java.util.Stack;

/**
 * Created by eric-d on 2017/6/27.
 */
public class MaximalSquare {
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
