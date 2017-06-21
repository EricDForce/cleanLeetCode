/**
 * Created by eric-d on 2017/6/20.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, sum=0, MIN = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum>=s){
                if((i-start) < MIN){
                    MIN = i-start+1;
                }
                int tmp = sum-nums[start];
                if(tmp>=s){
                    sum = tmp;
                    start++;
                }else{
                    break;
                }
            }
        }
        return (MIN==Integer.MAX_VALUE) ? 0 : MIN;
    }
}
