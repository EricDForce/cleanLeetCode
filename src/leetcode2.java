/**
 * Created by eric-d on 16/8/24.
 */
import java.util.ArrayList;
import java.util.List;
public class leetcode2 {
    public static void main(String[] args) {
        int[][] test = new int[2][2];
//        List<Integer> result = new leetcode2().spiralOrder(test);
        System.out.println(test[0][0]);
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();

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
}
