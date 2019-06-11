package algorithmcode;

/**
 * @author : dengli
 * @date : 2019/05/17.
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6,8,9,45,67,87};
		System.out.println(BinarySearch.binarySearch(nums, 3));
	}

	public static int binarySearch(int[] nums, int x) {
		int left = 0, right = nums.length-1;
		while (left < right) {
			int mid = (left + right)/2;
			if (nums[mid]==x) {
				return mid;
			}
			left = (nums[mid] > x) ? left : mid;
			right = (nums[mid] > x) ? mid : right;
		}
		return -1;
	}
}
