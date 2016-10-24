public class NumArray {
    int[]num;
    int[]sum;   //prefix sum good for less update operation
    public NumArray(int[] nums) {   //O(N) build
        num = nums;
        sum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++)
            sum[i] = sum[i-1] + num[i-1];
    }

    void update(int i, int val) {
        //O(N)
        for(int j=i+1; j<sum.length; j++){
            sum[j] = sum[j] + val - num[i];
        }
        num[i] = val;
    }

    public int sumRange(int i, int j) {
        //Constant retrieve
        return sum[j+1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);


public class NumArray {
    //Binary Index Tree
    int[] nums;
    int[] BIT;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n+1];
        for(int i=0;i<n;i++)
            init(i, nums[i]);
    }
    
    public void init(int i, int val){
        i++;
        while(i<=n){
            BIT[i] += val;
            i += (i&-i);
        }
    }
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }
    public int getSum(int i){
        int sum = 0;
        i++;
        while(i>0){
            sum+=BIT[i];
            i-=(i&-i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);


public class NumArray {
    Node root;  //Root of segment tree
    //Segment Tree Node, start end index and sum
    class Node{
        int start, end ,sum;
        Node left, right;
        public Node(int start, int end ,int sum){
            this.start = start; 
            this.end = end;
            this.sum = sum;
        }
    }
    //Build segment tree from array
    public Node build(int start, int end, int[]nums){
        if(start > end) return null;
        Node node = new Node(start, end, nums[start]);
        if(start == end)    
            return node;
        int mid = (end - start)/2;
        node.left = build(start, mid, nums);    //Build left subtree
        node.right = build(mid + 1, end, nums); //Build right subtree
        node.sum = node.left.sum + node.right.sum;  //Combine the sum
        return node;
    }
    private Node buildTree(int start, int end, int[] nums) {
        if (start > end) 
            return null;
        
        Node ret = new Node(start, end, nums[start]);
        if (start == end) 
            return ret;
        
        int mid = start  + (end - start) / 2;             
        ret.left = buildTree(start, mid, nums);
        ret.right = buildTree( mid + 1, end, nums);
        ret.sum = ret.left.sum + ret.right.sum;
                
        return ret;
        
    }
    public void update(Node root, int idx, int val){
        if(idx < root.start || idx > root.end)
            return; //Invalid
        if(idx == root.start && idx == root.end){
            root.sum = val;
            return;
        }
        //Search 
        int mid = root.start + (root.end - root.start)/2;
        if(idx >= root.start && idx <= mid){    //If left Subtree
            update(root.left, idx, val);
        }
        if(idx > mid && idx <= root.end){
            update(root.right, idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int query(Node root, int start, int end){
        if(start > end || root == null) return 0;
        if(start <= root.start && end >= root.end){
            return root.sum;
        }
        int left = 0, right = 0;
        int mid = root.start + (root.end - root.start)/2;
        if(start <= mid)
            left = query(root.left, start, Math.min(mid, end));    
        if(end > mid)
            right = query(root.right, Math.max(mid+1, start), end);
        return left+right;
    }

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length-1, nums);
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
