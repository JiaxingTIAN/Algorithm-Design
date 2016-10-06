public class Solution{

  class Node{
    TreeNode node;
    int col;
    public Node(TreeNode node, int col){
      this.node = node;
      this.col = col;
    }
  }
  
  public List<List<Integer> verticalOrder(TreeNode root){
    List<List<Integer>> ans = new LinkedList<>();
    if(root == null)
      return ans;
    
    Map<Integer, List<Integer>> map = new TreeMap<>();  //for auto ordering
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(root, 0));
    //BFS
    while(!queue.isEmpty()){
      Node node = queue.poll();
      map.putIfAbscent(node.col, new LinkedList<Integer>());
      map.get(node.col).add(node.node.val);
      
      if(node.node.left!=null)
        queue.offer(new Node(node.node.left, col-1));
      if(node.node.right!=null)
        queue.offer(new Node(node.node.right, col+1);
    }
    for(List list:map.values()) 
      ans.add(list);
    return ans;
  }
}
//Use of HashMap is more efficent
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
    //Wrapper class to store both the TreeNode and the col index
    class Node{
        int col;
        TreeNode node;
        public Node(TreeNode node, int col){
            this.col = col;
            this.node = node;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int min = 0, max = 0;
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        //To store the col index with according list of TreeNode
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        BFS 
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int col = cur.col;
            map.putIfAbsent(col, new LinkedList<>());
            map.get(col).add(cur.node.val);
            if(cur.node.left != null){
                queue.offer(new Node(cur.node.left, col-1));
                min = Math.min(col - 1, min);
            }
            if(cur.node.right != null){
                queue.offer(new Node(cur.node.right, col+1));
                max = Math.max(col + 1, max);
            }
        }
        for(int i=min; i<=max; i++){
            res.add(map.get(i));
        }
        return res;
        // Map<Integer, List<Integer>> map = new TreeMap<>();
        // while(!queue.isEmpty()){
        //     Node cur = queue.poll();
        //     map.putIfAbsent(cur.col, new LinkedList<>());
        //     map.get(cur.col).add(cur.node.val);
        //     if(cur.node.left != null){
        //         queue.offer(new Node(cur.node.left, cur.col - 1));
        //     }
        //     if(cur.node.right != null){
        //         queue.offer(new Node(cur.node.right, cur.col + 1));
        //     }
        // }
        // for(List list:map.values()){
        //     res.add(list);
        // }
        // return res;
    }
}
    
