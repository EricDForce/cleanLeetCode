import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dengli on 2019/01/14.
 */
public class subSets {
    public static void main(String[] argv) {
        int[] nums = {1, 2, 3};
        System.out.println(new subSets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        backtrack2(nums, res, 0, tmp);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, int index, List<Integer> tmp) {
        if (index==nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }else {
            tmp.add(nums[index]);
            backtrack(nums, result, index + 1, tmp);
            tmp.remove(tmp.size() - 1);
            backtrack(nums, result, index + 1, tmp);
        }
    }

    public void backtrack2 (int[] nums, List<List<Integer>> result, int start, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int i=start; i<nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, result, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    //with duplicates, sort the Array nums
    public void backtrack3 (int[] nums, List<List<Integer>> result, int start, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int i=start; i<nums.length; i++) {
            if (i>start && nums[i-1]==nums[i]) continue;
            tmp.add(nums[i]);
            backtrack(nums, result, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
