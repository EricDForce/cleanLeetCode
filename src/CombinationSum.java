import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args){
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(candidates, 7);
        for (List<Integer> list : res){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(tmp, res, 0, target, candidates);
        return res;
    }
    public static void backtrack(List<Integer> tmp, List<List<Integer>> result, int start, int target, int[] candidates){
        if (target < 0)
            return ;
        if (target == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backtrack(tmp, result, i, target-candidates[i], candidates);
                tmp.remove(tmp.get(tmp.size()-1));
            }
        }
    }
}
