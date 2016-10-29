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
    int val;
    double diff;
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return -1;
        val = root.val;
        diff = Math.abs(target - val);
        dfs(root, target);
        return val;
    }
    public void dfs(TreeNode node, double target){
        if(node == null)    return;
        double d = Math.abs(target - node.val);
        if(diff > d){
            diff= d;
            val = node.val;
        }
        dfs(node.left, target);
        dfs(node.right, target);
    }
}
//Time Complexity => O(logn)
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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double diff = Math.abs(target - res);
        while(root != null){
            double d = Math.abs(root.val - target);
            if(d < diff){
                res = root.val;
                diff = d;
            }
            root = target > root.val? root.right:root.left;
        }
        return res;
    }
}
