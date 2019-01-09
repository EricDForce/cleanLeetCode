/**
 * Created by dengli on 2019/01/06.
 */
public class JumpGame {

    public static void main(String[] argv) {
        int[] nums = new int[]{3, 2, 1, 1, 4};
        System.out.println(new JumpGame().canJump2(nums));
    }
    //[2,3,1,1,4] => true; [3,2,1,0,4] => false
    //dynamic programming编程
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n+1];
        canJump[n-1] = true;
        for (int i=n-2; i>=0; i--) {
            canJump[i] = false;
            if ((nums[i]+i) >= n) {
                canJump[i] = true;
            }else {
                for (int j=i+1; j<=(nums[i]+i); j++) {
                    if (canJump[j]) canJump[i] = true;
                }
             }
        }
        return canJump[0];
    }
    //greedy,only need to keep the left-good value
    public boolean canJump2(int[] nums) {
        if (nums.length <= 0) return true;
        int leftGood = nums.length-1;
        for (int i=nums.length-2; i>=0; i--) {
            leftGood = (nums[i]+i>=leftGood) ? i : leftGood;
        }
        if (leftGood==0) return true;
        return false;
    }
}
