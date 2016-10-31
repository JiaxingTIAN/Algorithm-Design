public class Solution{
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null)
            return null;
        TreeNode ancester = root;
        while(true){
            if(p.val < ancester.val && q.val < ancester.val)
                ancester = ancester.left;
            else if(p.val > ancester.val && q.val > ancester.val)
                ancester = ancester.right;
            else
                break;
        }
        return ancester;
    }
}
