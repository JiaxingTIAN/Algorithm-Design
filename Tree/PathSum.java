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
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }
    public boolean pathSum(TreeNode node, int cur, int sum){
        if(node == null)    return false;
        cur += node.val;
        if(node.left == null && node.right == null){    //If leaf node
            return cur == sum;
        }
        return pathSum(node.left, cur, sum) || pathSum(node.right, cur, sum);
    }
}


public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
