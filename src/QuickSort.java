/**
 * Created by eric-d on 2017/6/25.
 */
public class QuickSort {
    public static void main(String[] args)
    {
        int[] nums = {1,9,7,8,3,5,4,7};
        new QuickSort().quicksort(nums, 0, nums.length-1);
        for (int i : nums)
        {
            System.out.print(i+" ");
        }
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
    public static int partition(int[] nums, int l, int r)
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
}
