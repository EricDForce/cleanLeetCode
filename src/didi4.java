import java.util.*;

public class didi4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] result = new int[n][n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        result = getKPartition(nums, 2);
        for (int i=0;i<n;i++) {
            System.out.println(result[i][0] + " , "+ result[i][1]);
        }
    }

    public static int[][] getKPartition(int[] nums, int k){
        int res = 0, sum = 0, index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[][] result = new int[nums.length][nums.length];
        for (int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum%k)) {
                result[index][0] = map.get(sum%k);
                result[index][1] = i;
                map.clear();
            }
            map.put(sum/k, i);
        }
        return result;
    }
    public static int getPartition(int[] nums) {
        int res = 0, n = nums.length, count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res = res ^ nums[i];
            if (set.contains(res)) {
                count++;
                set.clear();
            }
            set.add(res);
        }
        return count;
    }
}
