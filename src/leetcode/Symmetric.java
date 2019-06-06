import java.util.*;

/**
 * Created by eric-d on 2016/12/24.
 */
public class Symmetric {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args)
    {
        Symmetric tt = new Symmetric();
        TreeNode root = tt.new TreeNode(1);
        List<Integer> tmp = new ArrayList<>();
        root.left = null;
        root.right = null;
        System.out.println(tt.isSymmetric2(root.left, root.right));
    }

    public List<Integer> preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();     层次遍历
//        TreeNode ptr = root;
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            TreeNode tmp = queue.poll();
//            if (tmp!=null){
//                res.add(tmp.val);
//                queue.offer(tmp.left);
//                queue.offer(tmp.right);
//            }
//        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if (tmp!=null) {
                res.add(tmp.val);
                stack.push(tmp.right);
                stack.push(tmp.left);
            }
        }
        return res;
    }
    public boolean isSymmetric2(TreeNode lt, TreeNode rt)
    {

        if((lt==null && rt==null))
        {
            return true;
        }
        if((lt==null && rt!=null) || (lt!=null && rt==null) || (lt.val!=rt.val))
        {
            return false;
        }

        return isSymmetric2(lt.left, rt.right) && isSymmetric2(lt.right, rt.left);
    }
}
