/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    List<Integer> list = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    //O(N)
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return list.remove(0);
    }
}
