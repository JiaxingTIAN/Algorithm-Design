#Valid BST

* PreOrder traversal update min and max value each time
* for overflow problem use Long.MIN_VLAUE and Long.MAX_VALUE;

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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean valid(TreeNode node, long min, long max){  //Passing min and max constraint for node.val
        if(node == null){
            return true;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        //for left child update max to be parent val and keep min
        //for right child update min to be parent val and keep max
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}
```
* Inorder Traversal -- Better Version

Record a previous node to compare as Globel variable

```java
public class Solution{
    TreeNode pre = null;
    public boolean isValid(TreeNode root){
        if(root == null) 
            return true;
        if(!isValid(root.left))
            return false;
        if(pre != null && pre.val >= root.val)
            return false;
        pre = root;
        return isValid(root.right);
    }
}
```
