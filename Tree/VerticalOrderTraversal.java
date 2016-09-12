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
    for(List list:map.entrySet()) 
      ans.add(list);
    return ans;
  }
}
    
    
