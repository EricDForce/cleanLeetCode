/**
 * Created by eric-d on 2016/12/24.
 */
import java.util.*;
public class levelorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> getlevel(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(root==null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tail = root;
        TreeNode last = root;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();  //出队头元素并访问

            tmp.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
                tail = current.left;
            }
            if (current.right != null) {
                queue.offer(current.right);
                tail = current.right;
            }

            if(current == last)
            {
                last = tail;
                List<Integer> list = new ArrayList<>();
                list.addAll(tmp);
                tmp.clear();
                result.add(list);
            }
        }
        return result;
    }
}
