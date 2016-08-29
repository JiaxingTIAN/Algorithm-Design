public class Solution{
  class UnionFind{
    HashMap<Integer, Integer> father = new HashMap<>();
    //Initialize the stucture
    UnionFind(HashSet<Integer> hashset){
      for(Integer i:hashset){
        father.put(i, i);
      }
    }
    //find the big boss---identifier of the component
    int find(int x){
      int parent = father.get(x);
      while(parent != fahter.get(parent))
        parent = father.get(parent);
      return parent;
    }
    
    int compressed_find(int x){
      int parent = father.get(x);
      while(parent != father.get(parent))
        parent = father.get(parent);
      
      while(x != father.get(x)){
        int next = father.get(x);
        father.put(x, parent);
        x = next;
      }
      return parent;
    }
    
    void union(int x, int y){
      int fa_x = find(x);
      int fa_y = find(y);
      if(fa_x != fa_y)
        father.put(fa_x, fa_y);
    }
  }
  
  List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n){
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> hashMap = new HashMap<>();
    for(int i:hashSet){
      int fa = uf.find(i);
      hashMap.putIfAbsent(fa, new ArrayList<Integer>());
      hashMap.get(fa).add(i);
    }
    for(List<Integer> now：hashMap.values()){
      Collections.sort(now);
      ans.add(now);
    }
    return ans;
  }
  
  public List<List<Integer>> connectedSet(ArrayList<DirectedGraphNode> nodes){
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for(DirectedGraphNode now:nodes){
      hashSet.add(now.label);
      for(DirectedGraphNode neighbour:now.neighbors){
        hashSet.add(neighbour.label);
      }
    }
    UnionFind uf = new UnionFind(hashSet);
    
    for(DirectedGraphNode now:nodes){
      for(DirectedGraphNode neighbor:now.neighbors){
        int fnow = uf.find(now.label);
        int fneighbor = uf.find(neighbor.label);
        if(fnow!=fneighbor){
          uf.union(now.label, neighbor.label);
        }
      }
    }
    return print(hashSet, uf, nodes.size());
  }
}
