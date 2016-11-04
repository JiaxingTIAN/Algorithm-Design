#Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

* For example:
```
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
```
*return its level order traversal as:*
```
[
  [3],
  [9,20],
  [15,7]
]
```

*Code with BFS use of Queue*
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        BFS
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }
    
}
```
*DFS passing the level as parameter*
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    //DFS
    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        if(node == null)
            return;
        if(level >= res.size()){
            List<Integer> list = new LinkedList<Integer>();
            res.add(list);
        }
        List<Integer> l = res.get(level);
        l.add(node.val);
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}
```
**Bottom Up as a follow up**
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(0, list);
        }
        return res;
        //List<List<Integer>> res = new ArrayList<>();
        //dfs(root, res, 0);
        //return res;
    }
    //DFS => NOT GOOD 
    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        if(node == null){
            return;
        }
        //Need to add new list to the front
        if(level >= res.size()){
            res.add(0, new LinkedList<>());
        }
        //get the list to be added
        res.get(res.size() - level - 1).add(node.val);
        //Continue dfs
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }
    
}
