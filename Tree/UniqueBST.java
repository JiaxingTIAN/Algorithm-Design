/**
 * Created by star on 10/30/16.
 */
import java.util.*;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public List<TreeNode> generateTree(List<List<List<TreeNode>>> dp, int start, int end){
        //Complexity N^N without memoization
        System.out.println("Build from " + start + " to " + end);
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(dp.get(start).get(end).size() != 0){
            return dp.get(start).get(end);
        }
        System.out.println("Not existed before");

        for(int i=start; i<=end; i++){
            List<TreeNode> left = generateTree(dp, start, i-1);
            List<TreeNode> right = generateTree(dp, i+1, end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        dp.get(start).get(end).addAll(res);
        return res;
    }

    public List<TreeNode> buildTree(int n){
        //Complexity with memoization is O(n^3)
        List<TreeNode>[][] memo = new List[n+1][n+1];
        List<List<List<TreeNode>>> dp = new ArrayList<>();
        for(int i=0;i<=n; i++){
            List<List<TreeNode>> tmp = new ArrayList<>();
            for(int j=0; j<=n; j++){
                tmp.add(new ArrayList<>());
            }
            dp.add(tmp);
        }
        for(int i=1; i<=n; i++){
            dp.get(i).get(i).add(new TreeNode(i));
        }
        return generateTree(dp, 1, n);
    }
    public static void main(String[] args){
        Solution soln = new Solution();
        List<TreeNode> ans = soln.buildTree(5);
        System.out.println(ans.size());
    }
}
