/**
 * Created by eric-d on 2017/6/24.
 */
public class Searcha2DMatrix {
    public static void main(String[] args)
    {
        int[][] matrix = {{1},{3}};
        System.out.println(new Searcha2DMatrix().searchMatrix(matrix, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int rows = matrix.length, cols = matrix[0].length, l = 0, r = rows-1, row = 0, lrow = 0, col = cols-1;
        while (l <= r)        //两次二分查找
        {
            int mid = (l+r)/2;
            if (matrix[mid][0]>target)
            {
                r = mid - 1;
            }else{
                if (mid == rows-1)
                {
                    row = mid;
                    break;
                }
                if (matrix[mid+1][0]>target){
                    row = mid;
                    break;
                }
                l = mid + 1;
            }
        }

        while(lrow <= col)
        {
            int mid = (lrow+col)/2;
            if (matrix[row][mid] == target){
                return true;
            }else if (matrix[row][mid] < target){
                lrow = mid + 1;
            }else{
                col = mid - 1;
            }
        }
        return false;
    }
}
