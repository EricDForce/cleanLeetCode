/**
 * Created by eric-d on 2017/6/23.
 */
public class SearchforaRange {
    public static void main(String[] args)
    {
        int[] nums = {};
        int[] t = new SearchforaRange().searchRange(nums, 8);
        for (int i : t) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0)
            return new int[]{-1,-1};
        return new int[]{helper(nums, target, true, 0, nums.length-1), helper(nums, target, false, 0, nums.length-1)};
    }
    public int helper(int[] nums, int target, boolean dir, int l, int r)
    {
        if (l>r)
        {
            return -1;
        }
        int mid = (l+r)/2;
        if (nums[mid] < target){
            return helper(nums, target, dir, mid+1, r);
        }else if (nums[mid] > target){
            return helper(nums, target, dir, l, mid-1);
        }else{
            if (dir) {
                if (mid==0){
                    return mid;
                }
                if ((mid-1) >= 0 && nums[mid - 1] < target) {
                    return mid;
                } else {
                    return helper(nums, target, dir, l, mid - 1);
                }
            }else{
                if (mid == nums.length-1){
                    return mid;
                }
                if ((mid+1) < nums.length && nums[mid + 1] > target) {
                    return mid;
                } else {
                    return helper(nums, target, dir, mid + 1, r);
                }
            }
        }
    }
}
