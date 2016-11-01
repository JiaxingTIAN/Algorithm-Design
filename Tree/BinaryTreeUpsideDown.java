/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)    //empty 
            return root;
        if(root.left == null && root.right == null) //leaf as root
            return root;
        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;   //To be arrange by upper level
        root.right = null;
        return node;
    }
}
