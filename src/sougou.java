import java.util.*;

public class sougou {
    public static void main(String[] args){
        int[][] nums = {{2, 3}, {3, 4}, {5, 6}, {7, 8}};
        List<Set<Integer>> list = new ArrayList<>();
        new sougou().build(nums, list);
        for (int i=0; i<list.size(); i++){
            for (int j : list.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void build(int[][] nums, List<Set<Integer>> list){
        for(int i=0;i<nums.length;i++){
            boolean flag = false;
            for (int j=0;j<list.size();j++){
                Set set = list.get(j);
                if (set.contains(nums[i][0]) || set.contains(nums[i][1])){
                    flag = true;
                    set.add(nums[i][0]);
                    set.add(nums[i][1]);
                }
            }
            if (!flag){
                Set<Integer> tmp = new HashSet<>();
                tmp.add(nums[i][0]);
                tmp.add(nums[i][1]);
                list.add(tmp);
            }
        }
    }
}
