public class Solution{
    class TreeNode<E>{
        TreeNode left, right;
        E data;
        TreeNode(E data){
            this.data = data;
        }
    }
    public TreeNode invertBinaryTree(TreeNode root){
        invert(root);
        return root;
    }
    public invert(TreeNode node){
        if(node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invert(node.right);
        invert(node.left);
    }
}
