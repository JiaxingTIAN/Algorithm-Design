/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Impliment with LinkedList to traverse the tree before head
//O(N) -dfs; O(1) for hasNext() and next()
//O(N) for space complexity
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
//Implement with stack
//Space O(h) average Time O(1) worst O(h)
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
