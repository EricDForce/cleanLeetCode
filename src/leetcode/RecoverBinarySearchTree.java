import java.util.Stack;

/**
 * Created by eric-d on 2017/7/11.
 */
public class RecoverBinarySearchTree {
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE), firstNode = null, secondNode = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
    public void helper(TreeNode root){
        if (root ==null)
            return ;
        helper(root.left);
        if (firstNode ==null && preNode.val>=root.val){
            firstNode = preNode;
        }
        if (firstNode!=null && preNode.val>=root.val){    //secondNode肯定保存的是第二个错位的元素
            secondNode = root;
        }
        preNode = root;
        helper(root.right);
    }

    public void helper2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (firstNode==null && preNode.val>=cur.val){
                firstNode = preNode;
            }
            if(firstNode!=null && preNode.val>=cur.val){
                secondNode  = cur;
            }
            preNode = cur;
            cur = cur.right;
        }
    }
}
