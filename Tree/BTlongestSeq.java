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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, root.val, 1);
        return max;
    }
    public void dfs(TreeNode node, int val, int count){
        if(node == null){
            return;
        }
       count = node.val == val+1? count+1:1;
       max = Math.max(count, max);
       dfs(node.left, node.val, count);
       dfs(node.right, node.val, count);
    }
    
}
