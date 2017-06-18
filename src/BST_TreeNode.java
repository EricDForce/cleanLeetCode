/**
 * Created by eric-d on 2016/12/20.
 */
import java.util.*;

public class BST_TreeNode {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }

     public static void main(String[] args)
     {
//         List<TreeNode> result = new BST_TreeNode().generateTrees(2);

//         TreeNode t = new BST_TreeNode().new TreeNode(3);
//         t.left = null;
//         t.right = null;
//         new BST_TreeNode().insertBST(t, 4);
//         new BST_TreeNode().inorder(t);

//         new BST_TreeNode().BST_insert(t, 5);
//         new BST_TreeNode().inorder(t);
         //System.out.println(t.left.val);
         //System.out.println(t.right.val);
//         for(TreeNode tree : result)
//         {
//             new BST_TreeNode().inorder(tree);
//             System.out.println();
//         }
         int[] t1 = {1,2};
         int[] t2 = {2,1};

         TreeNode result = new BST_TreeNode().buildTree(t1, t2);

         new BST_TreeNode().inorder(result);
     }

     public void inorder(TreeNode tree)
     {
         if (tree != null)
         {
             inorder(tree.left);
             System.out.println(tree.val);
             inorder(tree.right);
         }else{
             return ;
         }
     }
    public List<TreeNode> generateTrees(int n) {
        //TreeNode T = new TreeNode();

        int[] nums = new int[n];

        for(int i=1;i<=n;i++)
        {
            nums[i-1] = i;
        }

        return generateTrees2(nums);
    }

    public List<TreeNode> generateTrees2(int[] nums)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        int len = nums.length;

        if(len<=0)
        {
            return result;
        }
        if(nums.length==1)
        {
            TreeNode T = new TreeNode(nums[0]);
            T.left = null;
            T.right = null;
            result.add(T);
            return result;
        }else{
            int[] tmp = new int[len-1];

            for(int i=0;i<len;i++)
            {
                int pos = 0;
                for(int j=0;j<len;j++)
                {
                    if(i!=j)
                        tmp[pos++] = nums[j];
                }
                List<TreeNode> ret = generateTrees2(tmp);

                for(TreeNode tree : ret)
                {
                    if(BST_insert(tree, nums[i]))
                    {
//                        System.out.println(tree.val);
                        result.add(tree);
                    }
                }
            }
        }
        return result;
    }

    public void insertBST(TreeNode root, int key){
        TreeNode p = root;
        /**记录查找结点的前一个结点*/
        TreeNode prev = null;
        /**一直查找下去，直到到达满足条件的结点位置*/
        while(p != null){
            prev = p;
            if(key < p.val)
                p = p.left;
            else if(key > p.val)
                p = p.right;
            else
                return;
        }
        /**prve是要安放结点的父节点，根据结点值得大小，放在相应的位置*/
        if(root == null)
            root = new TreeNode(key);
        else if(key < prev.val) {
            TreeNode tmp = new TreeNode(key);
            tmp.left = null;
            tmp.right = null;
            prev.left = tmp;
        }
        else {
            TreeNode tmp = new TreeNode(key);
            tmp.left = null;
            tmp.right = null;
            prev.right = tmp;
        }
    }
    public boolean BST_insert(TreeNode T, int k)
    {
        if(T==null)
        {
            TreeNode t = new TreeNode(k);
            t.left = null;
            t.right = null;
            T = t;
            System.out.println(k);
            return true;
        }else if(k==T.val)
        {
            return false;
        }else if(k<T.val)
        {
            TreeNode left = T.left;
            if(BST_insert(left, k)) {
                T.left = left;
                return true;
            }
        }else {
            TreeNode right = T.left;
            if (BST_insert(right, k)) {
                T.right = right;
                return true;
            }
        }
        return false;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int len = 0;
        int len1 = preorder.length;
        int len2 = inorder.length;
        int spl = 0;

        if (len1 != len2) {
            return null;
        }
        if (len1 <= 0) {
            return null;
        }
        if (len1 == 1) {
            TreeNode tree = new TreeNode(inorder[0]);
            tree.left = null;
            tree.right = null;
            return tree;
        }
        for (int i = 0; i < len2; i++) {
            if (inorder[i] == preorder[0]) {
                spl = i;
                break;
            }
        }

        int[] left = new int[spl];
        int[] leftin = new int[spl];
        int[] right = new int[len1 - 1 - spl];
        int[] rightin = new int[len1 - 1 - spl];
        for (int i = 1; i <= spl; i++) {
            left[i - 1] = preorder[i];
            leftin[i - 1] = inorder[i - 1];
        }

        for (int i = spl + 1; i < len1; i++) {
            right[i - spl - 1] = preorder[i];
            rightin[i - spl - 1] = inorder[i];
        }

        TreeNode leftree = buildTree(left, leftin);
        TreeNode rightree = buildTree(right, rightin);

        TreeNode result = new TreeNode(preorder[0]);
        result.left = leftree;
        result.right = rightree;

        return result;
    }
}
