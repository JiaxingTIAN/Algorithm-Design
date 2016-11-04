#Populating Next Right Pointers in Each Node

*Given a binary tree*
```
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
```
Initially, all next pointers are set to NULL.

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
```
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
```
After calling your function, the tree should look like:
```
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
```

**_Code_** 
```java
/*
*Definition for binary tree with next pointer.
*public class TreeLinkNode {
*    int val;
*    TreeLinkNode left, right, next;
*    TreeLinkNode(int x) { val = x; }
*}
*/
 
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode level = root;
        while(level != null){
            TreeLinkNode cur = level;
            while(cur != null){
                if(cur.left != null)
                    cur.left.next = cur.right;
                if(cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
    }
}
```
> For follow up, if the tree is not perfect
** Basic idea use a queue for level order traversal **
```java
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeLinkNode node = queue.poll();
                node.next = queue.peek();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i == size - 1)
                    node.next = null;
            }
        }
    }
}
```
** Optimize with constant space **
```java
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);   //Dummy node at beginning of each level
        TreeLinkNode cur = dummy;
        while(root != null){    //Start of each level
            while(root != null){ //Traverse each level
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = dummy.next;
            cur = dummy; 
            dummy.next = null;
        }
    }
}
```
