import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by eric-d on 2017/7/1.
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode t = stack.pop();
            if (t!=null){
                stack.push(t.right);
                stack.push(t.left);
                res.add(t.val);
            }
        }
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode t = stack.pop();
            if (t!=null){
                stack.push(t.left);
                stack.push(t.right);
                res.add(0, t.val);
            }
        }
        return res;
    }
}
