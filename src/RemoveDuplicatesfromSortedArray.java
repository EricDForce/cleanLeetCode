/**
 * Created by eric-d on 2017/6/18.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l=0,index=1,len=nums.length;
        while (index < len){
            if (nums[index] != nums[l]){
                nums[++l] = nums[index];
            }
            index++;
        }
        return l+1;
    }
}
