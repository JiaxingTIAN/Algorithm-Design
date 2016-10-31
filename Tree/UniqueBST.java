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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) 
            return new ArrayList<TreeNode>();
        return generateNode(1,n);
    }
    public List<TreeNode> generateNode(int start, int end){
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        //Try for every value
        for(int i=start;i<=end;i++){
            List<TreeNode> left = generateNode(start, i-1);
            List<TreeNode> right = generateNode(i+1, end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
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
//Naive Recursion O(N!) 
//Memoization O(N^3) 
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) 
            return new ArrayList<TreeNode>();
        List<TreeNode>[][] dp = new List[n+1][n+1];
        return generateNode(dp, 1, n);
        
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                
            }
        }
    }
    public List<TreeNode> generateNode(List<TreeNode>[][]dp, int start, int end){
        System.out.println("Hello World.");
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }
        System.out.println("Building: "+ start + " to " + end);
        //Try for every value
        for(int i=start;i<=end;i++){
            List<TreeNode> left = generateNode(dp, start, i-1);
            List<TreeNode> right = generateNode(dp, i+1, end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        dp[start][end] = list;
        return list;
    }
}
