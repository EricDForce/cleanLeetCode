import java.util.HashMap;
import java.util.Scanner;

public class Meituan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tmp = new int[N];
        for (int i=0;i<N;i++){
            tmp[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int max = checkSubarraySum(tmp, k);
        System.out.println(max);
    }
    public static int checkSubarraySum(int[] nums, int k) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer prev = map.get(k == 0 ? sum : sum % k);
            if (prev != null) {
                if (i - prev > 1) {
                    max = Math.max(max, (i-prev));
                }
            } else {
                map.put(k == 0 ? sum : sum % k, i);
            }
        }
        return max;
    }
}
