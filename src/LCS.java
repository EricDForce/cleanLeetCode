/**
 * Created by eric-d on 2017/2/3.
 */
import java.util.*;
public class LCS {
    public static void main(String[] args)
    {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LCS().longestConsecutive2(nums));
    }

    public int longestConsecutive(int[] nums){
        if (nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);

        int cnt = 1;
        int maxlen = 1;

        for (int i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1]){
                continue;
            }
            if ((nums[i]-nums[i-1]) == 1){
                cnt++;
            }else{
                if (cnt > maxlen)
                    maxlen = cnt;
                cnt = 1;
            }
        }
        return Math.max(maxlen, cnt);
    }
    public int longestConsecutive2(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 1;
        for (int ele : nums) {
            int left = ele - 1;
            int right = ele + 1;
            int cnt = 1;

            while (set.contains(left)) {
                cnt++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                cnt++;
                set.remove(right);
                right++;
            }

            max = Math.max(max, cnt);
        }
        return max;
    }
}
