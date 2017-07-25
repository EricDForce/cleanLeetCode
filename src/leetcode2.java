/**
 * Created by eric-d on 16/8/24.
 */
import java.util.ArrayList;
import java.util.List;
public class leetcode2 {
    public static void main(String[] args) {
//        int[][] test = {{1,2,3,7,8,9},{2,3,6,3,6,5},{3,4,5,6,3,2},{2,3,4,5,6,1},{4,5,6,2,3,7},{4,5,6,8,2,2}};
        int[][] test = {{2,3}};
        List<Integer> result = new leetcode2().spiral2Order(test);
        System.out.println(result);
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix[0].length == 1)
        {
            for (int i=0;i<matrix.length;i++)
            {
                result.add(matrix[i][0]);
            }
            return result;
        }

        if (matrix.length == 1)
        {
            for (int i=0;i<matrix[0].length;i++)
            {
                result.add(matrix[0][i]);
            }
            return result;
        }

        int i = 0;
        int j = 0;
        int right_max = matrix[0].length-1;
        int left_min = 0;
        int up_max = 1;
        int down_max = matrix.length-1;

        String flag = "right";

        while(true) {
            while(flag.equals("right")){
                result.add(matrix[i][j++]);
                if (j == matrix[0].length)
                {
                    flag = "exit";
                    break;
                }
                if (j == right_max){
                    if (i == down_max)
                    {
                        flag = "exit";
                        break;
                    }
                    right_max = right_max-1;
                    flag = "down";
                }
            }

            while(flag.equals("down")){
//                System.out.println("down i:"+i+" j:"+j);
                result.add(matrix[i++][j]);
                if (i == matrix.length)
                {
                    flag = "exit";
                    break;
                }

                if (i == down_max)
                {
                    if (j == left_min)
                    {
                        flag = "exit";
                        break;
                    }
                    down_max = down_max - 1;
                    flag = "left";
                }
            }

            while(flag.equals("left")){
//                System.out.println("left i:"+i+" j:"+j);
                result.add(matrix[i][j--]);
                if (j == left_min)
                {
                    if (i == up_max)
                    {
                        flag = "exit";
                        break;
                    }
                    left_min = left_min + 1;
                    flag = "up";
                }
            }

            while(flag.equals("up")){
//                System.out.println("up i:"+i+" j:"+j);
                result.add(matrix[i--][j]);
                if (i == up_max){
                    if (j == right_max)
                    {
                        flag = "exit";
                        break;
                    }
                    up_max = up_max + 1;
                    flag = "right";
                }
            }
//            System.out.println("up_max:"+up_max + " down_max:" + down_max + " left_min:"+ left_min + " right:" + right_max);
            if (flag.equals("exit"))
            {
                if (i >= matrix.length || j >= matrix[0].length)
                {
                    break;
                }
                result.add(matrix[i][j]);
                break;
            }
        }
        return result;
    }
    public List<Integer> spiral2Order(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int start = 0, m = matrix.length, n = matrix[0].length;
        if (m == 0){
            return result;
        }
        while (m > start * 2 && n > start * 2){
            helper(matrix, m, n, start, result);
            start++;
        }
        return result;
    }
    public void helper(int[][] matrix, int m, int n, int start, List<Integer> result){
        int endx = n-start-1, endy = m-start-1;
        //向右遍历
        for (int i=start;i<=endx;i++){
            result.add(matrix[start][i]);
        }
        //向下遍历
        for (int i=start+1;i<=endy;i++){
            result.add(matrix[i][endx]);
        }
        //向左遍历
        if (endx > start && endy > start)
        for (int i=endx-1;i>=start;i--){
            result.add(matrix[endy][i]);
        }
        //向上遍历
        if (endx > start && endy > start)
        for (int i=endy-1;i>start;i--){
            result.add(matrix[i][start]);
        }
    }
}
