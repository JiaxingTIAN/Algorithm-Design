/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Use queue for BFS with 2 iteration 1 for queue is empty 1 for iterate through the queue with current size
 //Time complexity O(N) Space complexity O(w) w is the maximum length
 
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
//Level order traversal II bottom up
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//O(N) time complexity
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
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Zig Zag traversal => O(N) time
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(reverse){
                    list.add(0, cur.val);
                }else{
                    list.add(cur.val);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(list);
            reverse = !reverse;
        }
        return res;
    }
}



//DFS 
public class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        if(node == null)
            return;
        if(level >= res.size()){
            List<Integer> newList = new LinkedList<>();
            res.add(newList);
        }
        List<Integer> list = res.get(level);
        list.add(node.val);
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
}
//DFS - bottom up
public class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    //Better to specify the List to be List<List<Integer>> for later use convience
    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        if(node == null)
            return;
        if(level >= res.size()){
            res.add(0, new LinkedList<>());
        }
        res.get(res.size() - level - 1).add(node.val);
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }
}

//DFS - ZigZag
public class Solution{
    public List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();    //ArrayList for fast retrival by index
        dfs(res, root, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, TreeNode node, int level){
        if(node == null){
            return;
        }
        if(level >= res.size()){
            res.add(new LinkedList<>());    //LinkedList for fast insertion for head
        }
        if(level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);
        dfs(res, node.left, level+1);
        dfs(res, node.right, level+1);
    }
}
                           
