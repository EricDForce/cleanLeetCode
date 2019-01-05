/**
 * Created by dengli on 2019/01/03.
 */
public class plusOne {

    public static void main (String[] argv) {
        int[] nums = {9,9,9,9};
        int[] result = new plusOne().plusOne(nums);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]+" ");
        }
    }
    //[1,2,3] => [1,2,4], [4,3,2,1] => [4,3,2,2]
    public int[] plusOne (int[] digits) {
        int n = digits.length;
        int[] res = new int[n+1];
        int plus = 1;
        for (int i=n-1; i>=0; i--) {
            int remain = (digits[i] + plus)%10;
            plus = (digits[i] + plus)/10;
            digits[i] = remain;
            res[i+1] = remain;
        }
        if (plus==0)
        {
            return digits;
        }else {
            res[0] = plus;
            return res;
        }
    }
}
