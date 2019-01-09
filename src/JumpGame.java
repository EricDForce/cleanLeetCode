/**
 * Created by dengli on 2019/01/06.
 */
public class JumpGame {
    //[2,3,1,1,4] => true; [3,2,1,0,4] => false
    //思路：f(i, j)表示能否从i到j，f(i, j) = {f(i+1, j), f(i+2, j), f(i+nums[i], j)}
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[][] canJump = new int[n][n];
        for (int i=0; i<n; i++) {

        }
        return true;
    }
}
