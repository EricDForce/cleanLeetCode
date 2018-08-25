import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args){
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = new ArrayList<>();
        new CombinationSumII().combinationSum2(candidates, 8, result, 9);
        for (List<Integer> iter : result){
            System.out.println(iter);
        }
    }
    public void combinationSum2(int[] candidatet, int target, List<List<Integer>> result, int start) {
        Arrays.sort(candidatet);
        helper(candidatet, target, result, new ArrayList<>(), 0);
        System.out.println(start);
    }
    public void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int index){
        if (target < 0)
            return ;
        if(target == 0){
            result.add(new ArrayList<Integer>(tmp));
            return ;
        }
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i-1]==candidates[i]) continue;
            tmp.add(candidates[i]);
            helper(candidates, target-candidates[i], result, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
