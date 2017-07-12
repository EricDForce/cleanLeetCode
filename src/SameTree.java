/**
 * Created by eric-d on 2017/7/1.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        if (p!=null && q!=null){
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }
        return false;
    }
}
