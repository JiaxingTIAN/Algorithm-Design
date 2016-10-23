/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start > end || root == null)
            return Integer.MIN_VALUE;
        if(root.start >= start && root.end <= end){
            return root.max;
        }
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int mid = root.start + (root.end - root.start)/2;
        if(start <= mid)
            left = query(root.left, start, Math.min(end, mid));
        if(end > mid)
            right = query(root.right, Math.max(mid+1, start), end);
        return Math.max(left, right);
    }
}

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start > end || root == null)    return 0;
        if(start <= root.start && end >= root.end){
            return root.count;
        }
        int left = 0, right = 0;
        int mid = root.start + (root.end - root.start)/2;
        if(start <= mid){
            left = query(root.left, start, Math.min(end, mid));
        }
        if(end > mid){
            right = query(root.right, Math.max(mid+1, start), end);
        }
        return left + right;
    }
}
