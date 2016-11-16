public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 4 || nums[0]*4 > target || nums[n-1]*4 < target) //Throw all invalid cases
            return res;
        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1, r = n-1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                    else if(sum > target)
                        r--;
                    else 
                        l++;
                }
            }
        }
        
        return res;
    }
}
