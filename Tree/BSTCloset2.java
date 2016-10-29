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
    class Point implements Comparable<Point>{
        int val;
        double diff;
        Point(int val, double diff){
            this.val = val;
            this.diff = diff;
        }
        public int compareTo(Point that){
            return this.diff > that.diff? -1:1;
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Point> hp = new PriorityQueue<>();  //Ascending order 
        search(hp, root, target, k);
        List<Integer> res = new ArrayList<>();
        while(!hp.isEmpty()){
            res.add(hp.poll().val);
        }
        return res;
    }
    public void search(PriorityQueue<Point> hp, TreeNode root, double target, int k){
        if(root == null)
            return;
        if(hp.size() < k){
            hp.offer(new Point(root.val, Math.abs(root.val - target)));
        }else{
            Point pt = hp.peek();
            if(pt.diff > Math.abs(root.val - target)){
                hp.poll();
                hp.offer(new Point(root.val, Math.abs(root.val - target)));
            }
        }
        search(hp, root.left, target, k);
        search(hp, root.right, target, k);
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
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> small = new Stack<>();
        Stack<Integer> big = new Stack<>();
        //the result stack is sorted since BST 
        inorder(root, target, small, false);    //get all the value smaller than target
        inorder(root, target, big, true);       //get all the value larger than target 
        List<Integer> res = new ArrayList<>();
        while(k-- > 0){
            if(small.isEmpty())
                res.add(big.pop());
            else if(big.isEmpty())
                res.add(small.pop());
            else if(Math.abs(small.peek() - target) < Math.abs(big.peek() - target))
                res.add(small.pop());   //Compare the difference and put the close one first
            else
                res.add(big.pop());
        }
        return res;
    }
    
    public void inorder(TreeNode node, double target, Stack<Integer> stack, boolean reverse){
        if(node == null)
            return;
        inorder(reverse?node.right:node.left, target, stack, reverse);
        if(reverse && node.val <= target)   //Stop if node value smaller than target when reverse
            return;
        if(!reverse && node.val > target)  //Stop if node value bigger than target when inorder
            return;
        stack.push(node.val);
        inorder(reverse? node.left:node.right, target, stack, reverse);
    }
}
