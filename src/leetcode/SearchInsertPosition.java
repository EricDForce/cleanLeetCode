/**
 * Created by eric-d on 2017/6/23.
 */
public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 0));
        System.out.println(new SearchInsertPosition().myPow(2, 5));
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
        while (true) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return mid + 1;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
    public double myPow(double x, int n) {
        if (n==0)
            return 1;

        if (n<0 && n==Integer.MIN_VALUE) {
            return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
        } else if (n<0 && n!=Integer.MIN_VALUE) {
            return 1.0 / (myPow(x, -n));
        }
        double tmp = myPow(x, n/2);
        if (n % 2==0){
            return tmp*tmp;
        }else{
            return tmp*tmp*x;
        }
    }
}
