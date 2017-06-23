/**
 * Created by eric-d on 2017/6/23.
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args){
        int[] num1 = {1,2};
        int[] num2 = {3};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(num1, num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m+n+1)/2, r = (m+n+2)/2;
        return (finKth(nums1, 0, nums2, 0, l) + finKth(nums1, 0, nums2, 0, r))/2.0;
    }
    public int finKth(int[] num1, int astart, int[] num2, int bstart, int k)
    {
        if (astart > num1.length-1) return num2[bstart];
        if (bstart > num2.length-1) return num1[astart];
        if (k == 1)
        {
            return Math.min(num1[astart], num2[bstart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (astart+k/2-1 < num1.length) aMid = num1[astart+k/2-1];
        if (bstart+k/2-1 < num2.length) bMid = num2[bstart+k/2-1];

        if (aMid < bMid)
            return finKth(num1, astart+k/2, num2, bstart, k-k/2);
        else
            return finKth(num1, astart, num2, bstart+k/2, k-k/2);
    }
}
