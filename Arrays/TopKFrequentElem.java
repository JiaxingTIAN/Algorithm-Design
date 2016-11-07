public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Construct an Array of list to store the value of different frequences
        //Initial size is nums.length+1 to avoid all the nums are same
        List<Integer> [] list = new List[nums.length+1];
        //Store the <Value, Frequence> Pair
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //But all the value with same frequence in the bucket
        for(int key:map.keySet()){
            int frequence = map.get(key);
            if(list[frequence]==null)
                list[frequence] = new LinkedList<Integer>();
            list[frequence].add(key);
        }
        //Return all the result
        List<Integer> res = new LinkedList<Integer>();
        for(int j=list.length-1;j>=0&&res.size()<k;j--)
            if(list[j]!=null) res.addAll(list[j]);
        return res;
        
    }
}
