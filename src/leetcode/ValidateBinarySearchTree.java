/**
 * Created by eric-d on 2017/7/1.
 */
public class ValidateBinarySearchTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int min, int max){
        if (root==null) return true;
        if (root.val >=max || root.val<=min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
