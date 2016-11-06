public class Solution {
    int[]roots;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(m <= 0 || n <= 0)
            return res;
        roots = new int[m*n];
        Arrays.fill(roots, -1); //-1 for unvisited
        int count = 0;
        for(int[]p:positions){
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;
            for(int[]d:dir){
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                if(x < 0 || x >= m || y < 0 || y >= n || roots[x*n+y] == -1)
                    continue;
                int fax = find(root);
                int fay = find(x*n+y);
                if(fax != fay){
                    roots[fax] = fay;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    //Compress Union Find
    public int find(int num){
        int fa = num;
        while(fa != roots[fa]){
            fa = roots[fa];
        }
        while(num != roots[num]){
            int tmp = roots[num];
            roots[num] = fa;
            num = tmp;
        }
        return fa;
    }
    //find boss and path compression
    public int getRoot(int[] root, int id){
        if(root[id] == id){
            return id;
        }
        root[id] = getRoot(root, root[id]);
        return root[id];
    }
    public void union(int x, int y){
        int fax = find(x);
        int fay = find(y);
        if(fax != fay){
            roots[fax] = fay;
        }
    }
}
