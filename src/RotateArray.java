import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 2017/6/23.
 */
public class RotateArray {
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,5,6};
        new RotateArray().rotate(nums, 1);

        for (int i : nums)
        {
            System.out.print(i+" ");
        }
    }
    public void rotate(int[] nums, int k) {
        helper(nums, 0, nums.length);
        helper(nums, 0, k);
        helper(nums, k, nums.length);
    }
    public void helper(int[] nums, int l, int r)
    {
        int t = 0;
        while (l < r)
        {
            t = nums[l];
            nums[l] = nums[r-1];
            nums[r-1] = t;
            l++;
            r--;
        }
    }
}
