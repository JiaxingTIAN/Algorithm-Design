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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder==null) return null;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i], i);  //For fast retrieve
        return buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, hm);
    }
    public TreeNode buildTree(int[]inorder, int is, int ie, int[]preorder, int ps, int pe, HashMap<Integer, Integer> hm){
        if(is>ie||ps>pe) 
            return null;
        TreeNode root = new TreeNode(preorder[ps]); //Root is the preorder start
        int idx = hm.get(preorder[ps]); //Find root in inorder
        root.left = buildTree(inorder, is, idx-1, preorder, ps+1, ps+idx-is, hm);
        root.right = buildTree(inorder, idx+1, ie, preorder, ps+idx-is+1, pe, hm);
        return root;
    }
}
```
