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
    public static void main(String[] args)
    {

    }

    public List<List<Integer>> getlevel(BST_TreeNode.TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        Queue<BST_TreeNode.TreeNode> queue = new LinkedList<>();

        BST_TreeNode.TreeNode current = null;
        BST_TreeNode.TreeNode last = root;
        BST_TreeNode.TreeNode tail = root;
        queue.offer(root);
        List<Integer> tmp = new ArrayList<>();
        while(!queue.isEmpty())
        {
            current = queue.poll();  //出队头元素并访问

            tmp.add(current.val);

            if (current == last)
            {
                List<Integer> ft = new ArrayList<>();
                ft.addAll(tmp);
                result.add(ft);
                tmp.clear();
            }

            if (current.left != null)
            {
                queue.offer(current.left);
                tail = current.left;
            }

            if (current.right != null)
            {
                queue.offer(current.right);
                tail = current.right;
            }

            if(current == last)
            {
                last = tail;
            }
        }
        return result;
    }
}
