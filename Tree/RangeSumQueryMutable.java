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
    int [] bit;
    int [] num;
    int n;
    public NumArray(int[] nums) {
        this.num = nums;
        n = nums.length;
        bit = new int[n+1];     //padding with 0
        for(int i=0; i<n; i++)  //Update the whole array
            init(i, nums[i]);
    }
    
    public void init(int i, int val){
        i++;    //padding with 0 increment first
        while(i <= n){
            bit[i] += val;
            i = i + (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - num[i];
        num[i] = val;
        init(i, diff);
    }

    public int getSum(int i){
        int res = 0;
        i++;
        while(i > 0){
            res += bit[i];
            i = i - (i & -i);   //Obtain the last non zero bit i&-i
        }                       //Remove the last non zero bit for parent
        return res;             //bit[i] store sum of value from parent (exclusive parent)
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}
public class NumArray {
    int [] bit;
    int [] num;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        num = new int[n];
        bit = new int[n+1];     //padding with 0
        for(int i=0; i<n; i++)  //Update the whole array
            update(i, nums[i]);
    }
    
    void update(int i, int val) {
        int diff = val - num[i];
        num[i] = val;
        for(int k=i+1; k<=n; k += (k&-k))
            bit[k] += diff;
    }

    public int getSum(int i){
        int res = 0;
        for(int k=i+1; k > 0; k -= (k&-k))  //Obtain the last non zero bit i&-i
             res += bit[k];                 //Remove the last non zero bit for parent
        return res;                         //bit[i] store sum of value from parent (exclusive parent)
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
