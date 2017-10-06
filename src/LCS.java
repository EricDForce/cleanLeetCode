/**
 * Created by eric-d on 2017/2/3.
 */
import java.util.*;
public class LCS {
    public static void main(String[] args)
    {
        int[] nums = {100, 4, 200, 1, 3, 2};
        String str1 = "abcd", str2 = "acder";

//        System.out.println(new LCS().longestConsecutive2(nums));
        System.out.println(new LCS().getCommonSequnce(str1, str2));
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
    public int getCommonSequnce(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for (int i=1; i<=str1.length(); i++){
            for (int j=1; j<=str2.length(); j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
