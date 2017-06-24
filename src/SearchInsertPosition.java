/**
 * Created by eric-d on 2017/6/23.
 */
public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 0));
    }
    public int searchInsert(int[] nums, int target)
    {
        return helper(nums, target, 0, nums.length-1);
    }
    public int helper(int[] nums, int target, int l, int r)
    {
        if (nums[0] > target){
            return 0;
        }else if (nums[nums.length-1] < target){
            return nums.length;
        }
        int mid = (l + r)/2;
        if (nums[mid] == target)
        {
            return mid;
        }else if (nums[mid] < target){
            if (nums[mid+1] > target){
                return mid+1;
            }else{
                return helper(nums, target, mid+1, r);
            }
        }else{
            if (nums[mid-1] < target){
                return mid;
            }else{
                return helper(nums, target, l, mid-1);
            }
        }
    }
}
