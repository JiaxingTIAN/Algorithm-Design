public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        findSub(res, new LinkedList<Integer>(), nums, 0);
        return res;
    }
    
    public void findSub(List res, List sub, int[] nums, int start){
        res.add(new LinkedList(sub));
        for(int i=start; i<nums.length; i++){
            sub.add(nums[i]);
            findSub(res, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> sub = new LinkedList<>();
        res.add(sub);
        int start = 0;
        for(int j=0;j<nums.length;j++){
            int size = res.size();
            if(j>0 && nums[j-1] != nums[j]) start = 0;
            for(int i=start; i<size; i++){
                List<Integer> tmp = new LinkedList<Integer>(res.get(i));
                tmp.add(nums[j]);
                res.add(tmp);
            }
            start = size;
        }
        return res;
    }
}
