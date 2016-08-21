class Solution{
  public List<Integer> inorder(TreeNode root){
    List<Integer> res = new LinkedList();
    Stack<TreeNode> stack = new Stack();

    while(!stack.empty()||root!=null){
      if(root!=null){
        stack.push(root);
        root = root.left;
      }
      else{
        root = stack.pop();
        res.add(root.val);
        root = root.right;
      }
    }
    return res;
  }
}
