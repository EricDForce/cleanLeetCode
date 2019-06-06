import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zhaohang {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int k = sc.nextInt(), n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listtmp = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backtrack(list, listtmp, nums, n, 0);
        boolean flag = false;
        for (List<Integer> tmp : list){
            if(tmp.size() == k){
                flag = true;
                System.out.println(tmp);
            }
        }
        if (!flag){
            System.out.println("None");
        }
    }
    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
