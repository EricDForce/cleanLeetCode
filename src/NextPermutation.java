import java.io.File;
import java.util.HashMap;

/**
 * Created by eric-d on 2017/6/18.
 */
public class NextPermutation {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("dengli", 3);
        map.put("bowen", 5);
        HashMap<String, Integer> map1 = (HashMap<String, Integer>) map.clone();
        map1.remove("dengli");
        for (String str : map1.keySet()){
            System.out.println("key : " + str);
            System.out.println("value : " + map.get(str));
        }
//        System.out.println("file.separator: " + File.separator);
    }
    public void nextPermutation(int[] nums) {
        if (nums.length <= 0 || nums == null){
            return ;
        }

        int index = nums.length - 2;

        while(index >=0 && nums[index] >= nums[index+1]){
            index--;
        }

        if(index >= 0){
            int j = index+1;
            while(j<nums.length && nums[j] > nums[index])
                j++;
            j--;
            swap(nums, index, j);
        }
        reverseArray(nums, index+1, nums.length-1);
    }
    public void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public void reverseArray(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
