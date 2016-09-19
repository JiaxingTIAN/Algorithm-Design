class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        //Create the return list
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        //Corner cases
        if(nums == null || nums.length == 0){
            return ans;
        }
        Arrays.sort(nums);
        //Find the subsets with recursion
        findSubsets(ans, list, nums, 0);
        return ans;
    }
    //Backtrack
    public void findSubsets(ArrayList ans, ArrayList list, int[]nums, int i){
        //Add the current list by creating a new one
        ans.add(new ArrayList(list));
        for(int k = i; k<nums.length; k++){
            //Add the current elt first
            list.add(nums[k]);
            //Continue search for next pos
            findSubsets(ans, list, nums, k+1);
            //Remove the current elt, restore
            list.remove(list.size()-1);
        }        
    }
}
