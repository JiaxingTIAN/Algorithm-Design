public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if(nums == null){
            return list;
        }
        for(int i=0; i<nums.length; i++){
            String start = String.valueOf(nums[i]);
            while(i+1<nums.length && nums[i+1] == nums[i]+1){
                i++;
            }
            String end = String.valueOf(nums[i]);
            if(end.equals(start))
                list.add(end);
            else
                list.add(start + "->" + end);
        }
        return list;
    }
}
