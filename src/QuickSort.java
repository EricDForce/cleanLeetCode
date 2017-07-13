/**
 * Created by eric-d on 2017/6/25.
 */
public class QuickSort {
    public static void main(String[] args)
    {
//        int[] nums = {1,9,7,8,3,5,4,7};
//        new QuickSort().quicksort(nums, 0, nums.length-1);
//        for (int i : nums)
//        {
//            System.out.print(i+" ");
//        }
        System.out.println(new QuickSort().climbStairs(44));
    }
    public void quicksort(int[] nums, int l, int r)
    {
        if (nums==null || l < 0)
            return;
        int pivot;
        if (l < r)
        {
            pivot = partition(nums, l, r);
            quicksort(nums, l, pivot-1);
            quicksort(nums, pivot+1, r);
        }

    }
    public int partition(int[] nums, int l, int r)
    {
        int pivot = nums[l];
        while (l < r)
        {
            while(l<r && nums[r]>=pivot) r--;
            if (l<r) nums[l++] = nums[r];
            while (l<r && nums[l]<=pivot) l++;
            if (l<r) nums[r--] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        return helper(n, dp);
    }
    public int helper(int n, int[] nums)
    {
        if (nums[n] != 0){
            return nums[n];
        }
        int t1 = 0, t2 = 0;
        if (nums[n-1] != 0)
            t1 = nums[n-1];
        else
            t1 = helper(n-1, nums);
        if (nums[n-2] != 0)
            t2 = nums[n-2];
        else
            t2 = helper(n-2, nums);

        nums[n] = t1+t2;
        return nums[n];
    }
    public int climbStairs2(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
