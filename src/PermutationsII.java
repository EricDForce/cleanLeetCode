import java.util.*;

public class PermutationsII {
    public static void main(String[] args){
        int[] nums = {2,3,6,7};
        List<List<Integer>> result =  new PermutationsII().combinationSum(nums, 7);
        for (List<Integer> list : result){
            for (int t : list){
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), result,new boolean[nums.length]);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used){
        if (tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(nums, tempList, result, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, result, new ArrayList<Integer>(), target, 0);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> tempList, int target, int start){
        if (target < 0) return ;
        if (target == 0){
            result.add(new ArrayList<>(tempList));
        }else {
            for (int i=start; i<nums.length; i++){
                tempList.add(nums[i]);
                helper(nums, result, tempList, target-nums[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
