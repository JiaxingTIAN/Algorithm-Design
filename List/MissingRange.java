public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        //Exception 
        if(lower>upper){
            return res;
        }
        int n = nums.length;
        //Corner cases
        if(nums == null || nums.length == 0 || upper < nums[0] || lower > nums[n-1]){
            res.add(getRange(lower, upper));
            return res;
        }
        
        int next = lower;
        //In case upper is smaller than nums[n-1]
        for(int i=0; i<n && nums[i]<=upper; i++){
            if(nums[i] < lower){
                //Have not reach the lower yet
                continue;
            }
            //If nums[i] is 1 bigger than next continue checking
            if(nums[i] == next){
                next++;
                continue;
            }
            //Otherwise add the missing range from next to nums[i] - 1
            res.add(getRange(next, nums[i]-1));
            //Update the next to be nums[i] + 1
            next = nums[i] + 1;
        }
        //Finally check if any interval
        if(next <= upper){
            res.add(getRange(next, upper));
        }
        return res;
    }
    //Get the String range 
    public String getRange(int l, int h){
        return l == h? String.valueOf(h):String.format("%d->%d", l, h);
    }
}
