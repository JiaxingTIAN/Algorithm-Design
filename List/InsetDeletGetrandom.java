public class RandomizedCollection {

    /** Initialize your data structure here. */
    ArrayList<Integer> arr; //Arraylist for fast retrieve by idx
    Random rand;
    Map<Integer, Set<Integer>> map; //store the value and index
    
    public RandomizedCollection() {
        arr = new ArrayList<>();
        rand = new Random();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = !map.containsKey(val);
        map.putIfAbsent(val, new LinkedHashSet<>());
        map.get(val).add(arr.size());
        arr.add(val);
        return contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int idx = map.get(val).iterator().next();   //Get the index from LinkedHashSet
        map.get(val).remove(idx);   //Remove the index first avoid situation where last elem has the same value
        if(idx != arr.size()-1){    //If it is not the last element, exhange 
            int tmp = arr.get(arr.size()-1);
            arr.set(idx, tmp);  //Exchange the last with idx
            map.get(tmp).remove(arr.size()-1);  //Update the map
            map.get(tmp).add(idx);
        }
        arr.remove(arr.size()-1);
        
        if(map.get(val).isEmpty())
            map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
