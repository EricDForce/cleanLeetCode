import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 2017/7/1.
 */
public class SumRoottoLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//    static int sumit = 0;
    public static void main(String[] args){
//        TreeNode root = new SumRoottoLeafNumbers().new TreeNode(9);
//        System.out.println(new SumRoottoLeafNumbers().sumNumbers(root));
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(90);
        list.remove(90);
        for (int i : list){
            System.out.println(i);
        }
    }
    public int sumNumbers(TreeNode root) {
        int[] sumit = new int[1];
        helper(root, 0, sumit);
        return sumit[0];
    }
    public void helper(TreeNode root, int sum, int[] sumsum){
        sum = sum*10 + root.val;
        if (root.left==null&&root.right==null){
            sumsum[0] += sum;
            return ;
        }
        if (root.left != null){
            helper(root.left, sum, sumsum);
        }
        if (root.right != null){
            helper(root.right, sum, sumsum);
        }
    }
    public int helper2(TreeNode root, int sum){
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return sum*10 + root.val;
        }
        return helper2(root.left, sum) + helper2(root.right, sum);
    }
}
