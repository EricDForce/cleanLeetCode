/**
 * Created by eric-d on 2017/6/23.
 */
public class SingleNumberII {
    public static void main(String[] args){
        int[] nums = {2,3,3,3};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int res= 0;
        for (int i=0;i<32;i++){
            int cnt = 0, bits = (1<<i);
            for (int j=0;j<nums.length;j++){
                if ((nums[j]&bits) != 0) cnt++;
            }
            if (cnt%3 != 0)
            res |= bits;
        }
        return res;
    }
    public int[] singleNumber2(int[] nums){
        int AxorB = 0;
        for (int i : nums){
            AxorB ^= i;
        }
        int bitFlag = AxorB & (~(AxorB-1));      //求二进制数最低一位位一的位
        int[] result = new int[2];
        for (int i : nums){
            if ((bitFlag&i) == 0)
                result[0] ^= i;
            else
                result[1] ^= i;
        }
        return result;
    }
}
