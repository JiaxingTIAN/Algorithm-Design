public class Solution{
  public String serialize(TreeNode node){
    StringBuilder sb = new StringBuilder();
    preOrder(node, sb);
    return sb.toString();
  }
  public void preOrder(TreeNode node, StringBuilder sb){
    if(node == null){
      sb.append("#,");
      return;
    }
    sb.append(node.val).append(",");
    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }
  public TreeNode deserialize(String data){
    String[] str = data.split(",");
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(str));
    return buildTree(queue);
  }
  public TreeNode buildTree(Queue<String> queue){
    String str = queue.poll();
    if(str.equals("#")){
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(str));
    node.left = buildTree(queue);
    node.right = buildTree(queue);
    return node;
  }
}
