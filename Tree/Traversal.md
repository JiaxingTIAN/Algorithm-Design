#Binary Tree Traversal

## Inorder

> BST from small to large => left -> parent -> right

```java
class Solution{
  public List<Integer> inorder(TreeNode root){
    List<Integer> res = new LinkedList();
    Stack<TreeNode> stack = new Stack();

    while(!stack.empty()||root!=null){
      while(root!=null){
        stack.push(root);
        root = root.left;
      }
      
      root = stack.pop();
      res.add(root.val);
      root = root.right;
      
    }
    return res;
  }
}
```
##PreOrder

>Parent -> left -> right

```java
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Iterative Solution
        
        List<Integer> res = new LinkedList<Integer> ();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur != null){
                res.add(cur.val);
                stack.push(cur.right);  //push right first, pop out late
                stack.push(cur.left);
            }
        }
        return res;
        /*
        List<Integer> res = new LinkedList<Integer>();
        traversal(root,res);
        return res;*/
    }
    
    public void traversal(TreeNode node, List list){
        if(node==null) return;
        list.add(node.val);
        traversal(node.left,list);
        traversal(node.right,list);
    } 
}
```
##PostOrder

> left -> right -> parent

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
    public List<Integer> postorderTraversal(TreeNode root) {
        //pre-order traveral from parent-left-right post-order traversal left-right-parent
        //Construct parent-right-left and then reverse
        
        List<Integer> res = new LinkedList<>();
        if(root==null) 
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null) 
                stack.push(node.left);
            if(node.right!=null) 
                stack.push(node.right);
            
        }
        Collections.reverse(res);   //List is a collection
        return res;
        
    }
}
```
##Construct Tree from preorder and inorder
```java
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return build(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, map);
    }
    
    public TreeNode build(int[]in, int is, int ie, int[]pre, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe)
            return null;
        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(pre[ps]);
        root.left = build(in, is, idx-1, pre, ps+1, ps+idx-is, map);
        root.right = build(in, idx+1, ie, pre, ps+idx-is+1, pe, map);
        return root;
    }
}
```
##Construct BST from postOrder and Inorder

```java
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    
    public TreeNode build(int[]in, int is, int ie, int[]post, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe)
            return null;
        TreeNode node = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);
        node.left = build(in, is, idx-1, post, ps, ps+idx-1-is, map);
        node.right = build(in, idx+1, ie, post, ps+idx-is, pe-1, map);
        return node;
    }
}
```
##Width of BT with depth k
```java
public int width(TreeNode n, int depth){
    if(n == null)
      return 0;
    if(depth == 0)
      return 1;
    return width(n.left, depth-1) + width(n.right, depth-1);
}
public int height(TreeNode n){
    if(n == null)
      return -1;
    return Math.max(height(n.left), height(n.right)) + 1;
}
public int width(TreeNode root){
    int max = 0;
    int h = height(root);
    for(int i=0; i<=h; i++){
        max = Math.max(max, width(root, i));
    }
    return max;
}
```
##Diameter of BT

Longest Path between two leaf
```java
public int diameter(TreeNode n){
    if(n == null)
        return 0;
    int l1 = height(n.left) + height(n.right) + 3;  //Go through current root
    int l2 = Math.max(diameter(n.left), diameter(n.right)); //Dont go through root
    return Math.max(l1, l2);
}
