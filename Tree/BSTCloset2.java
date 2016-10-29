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
