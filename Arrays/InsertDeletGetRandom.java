public class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list; //ArrayList for fast look up with index
    Random rand;
    Map<Integer, Integer> map;    //map to store (val, index) pair
    
    public RandomizedSet() {
        list = new ArrayList<>();
        rand = new Random();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);  //Append to the last 
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        //Remove from the last
        if(idx != list.size()-1){
            //exchange value with last
            int last = list.get(list.size()-1);
            list.set(idx, last);
            map.put(last, idx);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size())); //Random.nextInt(n); [0,n) include 0 exclude n
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
