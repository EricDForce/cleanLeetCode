/**
 * Created by eric-d on 2017/3/5.
 */
import java.util.*;
public class Kpairs {

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        System.out.println(new Kpairs().findPairs(nums, 0));
    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();

        if(k<0){
            return 0;
        }else if (k==0){
            int cnt = 0;
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i]) && !map.get(nums[i])){
                    System.out.println("i:" + i + "nums[i]:" + nums[i]);
                    cnt++;
                    map.put(nums[i], true);
                }else if(map.containsKey(nums[i]) && map.get(nums[i])){
                    continue;
                }else {
                    map.put(nums[i], false);
                }
//                map.put(nums[i]-k, false);
            }
            return cnt;
        }else {
            int cnt = 0;
            for(int i=0;i<nums.length;i++){
                if(set.contains(nums[i])){
                    continue;
                }
                if(map.containsKey(nums[i]) && map.get(nums[i]) == false){
//                    System.out.println("i:" + i + "nums[i]:" + nums[i]);
                    cnt++;
                    map.put(nums[i], true);
                }
                set.add(nums[i]);
                map.put(nums[i]+k, false);
                map.put(nums[i]-k, false);
            }
            return cnt;
        }
    }
}
