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
    public int sumNumbers(TreeNode root) {
        //DFS
        return findLeaf(root, 0);
    }
    
    public int findLeaf(TreeNode root, int sum){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return sum*10 + root.val;
        return findLeaf(root.left, sum*10 + root.val) + findLeaf(root.right, sum*10 + root.val);
    }
}
