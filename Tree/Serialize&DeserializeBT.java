/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    //Preorder traversal, mark null with #, seperate with ,
    public void preOrder(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("#,");
            return;
        }
        sb.append(node.val + ",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        //Store the strings in a queue
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(str));
        return buildTree(queue);
    }
    
    public TreeNode buildTree(Queue<String> queue){
        String cur = queue.poll();
        if(cur.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
