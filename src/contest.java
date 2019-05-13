/**
 * Created by eric-d on 2017/3/5.
 */
import java.util.*;
public class contest {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new contest().findPairs(nums, 3));
    }
    public int findPairs(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])){
                cnt++;
            }
            list.add(k - nums[i]);
            list.add(k + nums[i]);
        }
        return cnt;
    }
}
