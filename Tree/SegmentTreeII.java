public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    class SegmentTreeNode{
        private int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max){
            this.start = start;
            this.end = end;fd
            this.max = max;
            this.left = this.right = null;
        }
    }
        
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return buildTree(0, A.length - 1, A);
    }

    public SegmentTreeNode buildTree(int start, int end, int[] A) {
        if (start > end)
            return null;

        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        int mid = (start + end) / 2;
        node.left = this.buildTree(start, mid, A);
        node.right = this.buildTree(mid + 1, end, A);
        if (node.left != null && node.left.max > node.max)
            node.max = node.left.max;
        if (node.right != null && node.right.max > node.max)
            node.max = node.right.max;
        return node;
    }
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        //Found the node
        if(index > root.end || index < root.start)
            return;
        if(root.start == index && root.end == index){
            root.max = value;
            return;
        }
        //Search
        int mid = root.start + (root.end - root.start)/2;
        if(root.start <= index && index <= mid)
            modify(root.left, index, value);
        if(root.end >= index && index > mid)
            modify(root.right, index, value);
        //Update the max
        root.max = Math.max(root.right.max, root.left.max);
    }
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
