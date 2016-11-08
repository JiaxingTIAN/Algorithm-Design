#Successor

*Time O(H)*

Smallest number that is greater than given number
```java
public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);  //smaller search for right subtree
  //greater than continue search for smaller value
  TreeNode left = successor(root.left, p);
  return (left == null) ? root : left;  //If no smaller return root
  
}
```
#Predecessor

Largest number that is smaller than given number
```java
public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p); //no smaller => Continue search for left subtree
  //Smaller continue search for larger value that smaller than p.val
  TreeNode right = predecessor(root.right, p);
  return (right == null) ? root : right;    //Return root if null
}
```
