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

#Maximum BST Subtree

* PostOrder Traveral using new class Tuple, have subtree size lower and upper bound.

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
    class Tuple{
        int size, low, up;  
        //Low is the lower bound of the subtree, up is the upper bound of subtree
        public Tuple(int s, int l, int u){
            size = s;
            low = l;
            up = u;
        }
    }
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        postOrder(root);
        return max;
    }
    public Tuple postOrder(TreeNode node){
        if(node == null)
            return new Tuple(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Tuple left = postOrder(node.left);
        Tuple right = postOrder(node.right);
        if(left.size == -1 || right.size == -1 || node.val <= left.up || node.val >= right.low)
            return new Tuple(-1, 0, 0);
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Tuple(size, Math.min(left.low, node.val), Math.max(right.up, node.val));
    }
}
```

#Recover BST 

The is one pair of node switched in the BST, find the nodes and recover BST.

* Use TreeNode first, second to record the 2 misplaced nodes
* Use TreeNode pre to store the previous node if node.val <= pre.val then invalid
* The first invalid is the larger one in the previous, the second is the smaller one in node

>For example, in order traverse 1,5,3,4,2,6 -> the first one is previous node, the second invalid one is current node


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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        if(pre!=null && first == null && node.val <= pre.val)
            first = pre;
        if(first != null && node.val <= pre.val)
            second = node;
        pre = node;
        inorder(node.right);
    }
}
```
