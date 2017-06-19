import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by eric-d on 2017/3/28.
 */
public class top_K {
    public static void main(String[] args){
//        int[] nums = new int[]{1,2,8,5,7,9,10,6};
//        PriorityQueue<Integer> res = new top_K().topK(nums, 3);
//        while (res.size()>0){
//            System.out.println(res.poll());
//        }
        List<List<Integer>> result = new top_K().SumIII(3, 7);
        for (List<Integer> list : result){
            for (int i : list){
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    public PriorityQueue<Integer> topK(int[] nums, int k){
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++){
            result.offer(nums[i]);
            if (result.size() > k){
                result.poll();
            }
        }
        return result;
    }

    public List<List<Integer>> SumIII(int k, int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(result, curr, 1, n, k);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> curr, int start, int n, int k){
        if (n<0)
            return ;
        if (n==0 && curr.size()==k){
            result.add(new ArrayList<>(curr));
            return ;
        }

        for (int i=start;i<10;i++){
            curr.add(i);
            helper(result, curr, i+1, n-i, k);
            curr.remove(curr.size()-1);
        }
    }
}
