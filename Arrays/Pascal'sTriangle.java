public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        if(numRows==0) return pascal;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++){
            sub.add(0,1);
            for(int j=1;j<sub.size()-1;j++){
                sub.set(j,sub.get(j) + sub.get(j+1));
            }
            pascal.add(new ArrayList<Integer>(sub));
        }
        return pascal;
    }
}
