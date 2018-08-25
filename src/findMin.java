public class findMin {
    public static void main(String[] args){
        int[] nums = {3,4,1,2};
        System.out.println(new findMin().findMin(nums));
    }
    public int findMin(int[] nums){
        int l=0, r = nums.length-1;
        if (nums.length == 1) return nums[0];
        if (nums[l] < nums[r]) return nums[0];
        else if(nums[r] < nums[r-1]) return nums[r]; //最后一个是最小的数
        else if(nums[r] < nums[r-1]) return nums[r];
        while(l <= r) {
            int middle = (l + r)/2;
            if(middle == 0 || middle==r) return nums[middle];  //确保middle-1和middle+1不越界
            if (nums[middle] < nums[middle-1] && nums[middle]<nums[middle+1]) return nums[middle];
            if(nums[middle] > nums[l]) l = middle;
            else if(nums[middle] < nums[l]) r = middle;
        }
        return nums[r];
    }
}
