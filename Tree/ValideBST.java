public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty()||cur!=null){ //for the first element, to enter the loop
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre!=null&&cur.val<=pre.val)
                    return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
//Recursion Solution
public class Solution {
    public boolean helper(TreeNode cur, Integer min, Integer max){
        if(cur==null) return true;
        if((min!=null&&cur.val<=min)||(max!=null&&cur.val>=max)) return false;
        return helper(cur.left, min, cur.val)&&helper(cur.right, cur.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
