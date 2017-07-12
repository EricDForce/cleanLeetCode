/**
 * Created by eric-d on 2017/2/8.
 */
public class sumNumbers {
    public static void main(String[] args){

    }

    public int sumNumber(TreeNode root)
    {
        return getSum(root, 0);
    }

    public int getSum(TreeNode root, int sum)
    {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null){
            return sum * 10 + root.val;
        }

        return getSum(root.left, sum*10 + root.val) + getSum(root.right, sum*10 + root.val);
    }
}
