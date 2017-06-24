/**
 * Created by eric-d on 2017/6/24.
 */
public class Sqrtx {
    public static void main(String[] args)
    {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(2147395599/2);
//        System.out.println(Math.sqrt(2147395599));
        System.out.println(new Sqrtx().mysqrt(1));
    }
    public int mySqrt(int x) {
        return helper(x, 1, x);
    }
    public int helper(int target, int l, int r){
        if (target == 0)
            return 0;
        while (l<=r) {
            int mid = l + (r-l)/2;
            System.out.println("l : " + l);
            System.out.println("mid : " + mid);
            if (mid > target / mid) {
                r = mid - 1;
            } else {
                if (mid + 1 > target/(mid+1))
                    return mid;
                l = mid + 1;
            }
        }
        return 0;
    }

    public int mysqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
