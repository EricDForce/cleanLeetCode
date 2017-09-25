import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class wangyiI {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int tmp = sc.nextInt();
            char[] nums = String.valueOf(tmp).toCharArray();
            boolean flag = false;
            List<Integer> result = subsetsWithDup(nums);
            for (int iter : result){
                if(iter != tmp && (iter % tmp==0)){
                    System.out.println("Possible");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("Impossible");
            }
        }
    }
    public static List<Integer> subsetsWithDup(char[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Character>(), nums, new boolean[nums.length]);
        return list;
    }

    public static void backtrack(List<Integer> list , List<Character> tempList, char[] nums, boolean [] used) {
        if (tempList.size()==nums.length){
            String str = "";
            for (char ch : tempList){
                str += ch;
            }
            list.add(Integer.valueOf(str));
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
