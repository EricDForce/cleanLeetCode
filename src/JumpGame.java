/**
 * Created by dengli on 2019/01/06.
 */
public class JumpGame {

    public static void main(String[] argv) {
        //int[] nums = new int[]{2, 3, 0, 1, 4};
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new JumpGame().jump2(nums));
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

    public int jump(int[] nums) {
        int n = nums.length;
        int[] jumpNum = new int[n];
        jumpNum[n-1] = 0;
        for (int i=n-2; i>=0; i--) {
            jumpNum[i] = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            if ((i+nums[i])>=(n-1)) {
                jumpNum[i] = 1;
            } else {
                for (int j=i+1; j<=(i+nums[i]); j++) {
                    min = Math.min(jumpNum[j], min);
                }
                if (min!=Integer.MAX_VALUE) {   //避免上面for循环的逻辑不走导致min+1溢出
                    jumpNum[i] = min + 1;
                }
            }
        }
        return jumpNum[0];
    }

    public int jump2(int[] nums) {
        if (nums.length==1) return 0;
        int cur = 0, end = 0, farthest = 0, n=nums.length, jump = 0;
        while (cur <= end) {
            if (farthest < (nums[cur] + cur)) {
                farthest = nums[cur] + cur;
            }
            if (farthest >= n-1) {
                return (jump+1);
            }else if (cur==end){
                if (farthest > end) {
                    jump++;
                    end = farthest;
                } else {
                    break;    //farthest<=end说明跳不出去了，不能跳到最后
                }
            } else {
                cur++;
            }
        }
        return 0;
    }
}
