import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric-d on 2017/6/27.
 */
public class UniqueBinarySearchTreesII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static void main(String[] args)
    {
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3));
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n+1];
        dp[0] = new ArrayList<TreeNode>();
        if (n==0){
            return dp[0];
        }
        dp[0].add(null);
        for (int i=1;i<=n;i++){
            dp[i] = new ArrayList<>();
            for (int j=0;j<i;j++){
                for (TreeNode nodeL : dp[j]){
                    for (TreeNode nodeR : dp[i-j-1]){
                        TreeNode newNode = new TreeNode(j+1);
                        newNode.left = nodeL;
                        newNode.right = clone(nodeR, j+1);
                        dp[i].add(newNode);
                    }
                }
            }
        }
        return dp[n];
    }
    public TreeNode clone(TreeNode node, int offset){
        if (node == null){
            return null;
        }
        TreeNode node1 = new TreeNode(node.val+offset);
        node1.left = clone(node.left, offset);
        node1.right = clone(node.right, offset);
        return node1;
    }
    public List<TreeNode> helper(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if (l>r){
            res.add(null);
            return res;
        }
        for (int i=l;i<=r;i++){
            List<TreeNode> nodeL = helper(l, i-1);
            List<TreeNode> nodeR = helper(i+1, r);
            for (TreeNode node1 : nodeL){
                for (TreeNode node2 : nodeR){
                    TreeNode node = new TreeNode(i);
                    node.left = node1;
                    node.right = node2;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
