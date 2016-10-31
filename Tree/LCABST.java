public class Solution{
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null)
            return null;
        TreeNode ancester = root;
        while(true){
            if(
