import java.util.Stack;

/**
 * Created by eric-d on 2017/6/27.
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args){
        int[] nums = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(nums));
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i=0, max_area=0, tp, area;
        while (i<heights.length)
        {
            if (stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }else {
                tp = stack.pop();
                area = heights[tp]*(stack.isEmpty() ? i : i-stack.peek()-1);
                if (area>max_area){
                    max_area = area;
                }
            }
        }
        while (!stack.isEmpty())
        {
            tp = stack.pop();
            area = heights[tp]*(stack.empty() ? i : i-stack.peek()-1);
            if (area>max_area){
                max_area = area;
            }
        }
        return max_area;
    }
}
