#250. Count Univalue Subtrees

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
```
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
```
**PostOrder traverse the tree left child right child and parent return false if not univalue**
```java
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
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        count(root);
        return count;
    }
    //Post Order traversal
    public boolean count(TreeNode root){
        if(root == null){
            return true;    //Univalue if leaf
        }
        boolean left = count(root.left);
        boolean right = count(root.right);
        if(left && right){  //True for left and right
            if(root.left != null && root.val != root.left.val)
                return false;
            if(root.right != null && root.val != root.right.val)
                return false;
            count++;
            return true;
        }
        return false; //Return false if left or right not true
    }
}
```
