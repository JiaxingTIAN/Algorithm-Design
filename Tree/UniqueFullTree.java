    public List<TreeNode> fullTree(int n){
        List<TreeNode>[] dp = new List[n+1];
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(new TreeNode(0));
        dp[1] = tmp;
        return buildTree(dp, n);
    }

    public List<TreeNode> buildTree(List<TreeNode>[] dp, int n){
        //Optimize with Memoization => Time Complexity O(n)
        if(dp[n] != null){
            return dp[n];
        }
        System.out.println("Building" + n);
        List<TreeNode> trees = new ArrayList<>();
        for(int i = 1; i < n; i++){
            List<TreeNode> left = buildTree(dp, i);
            List<TreeNode> right = buildTree(dp, n-i);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    trees.add(node);
                }
            }
        }
        dp[n] = trees;
        return trees;
    }
