//O(nlogn) time complexity O(n) space complexity
public class Solution{
    public void wiggleSort(int[] nums){
        if(nums==null || nums.length<2) return;
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];
        int left = (n-1)/2;
        int right = n-1;
        for(int i=0;i<n;i++){
            if(i&1==0){
                temp[i] = nums[left];
                left--;
            }
            else{
                temp[i] = nums[right];
                right--;
            }
        }
        System.arraycopy(temp,0,nums,0,n);
    }
}

#Python
def wiggleSort(self, nums):
    size = len(nums)
    sNums = sorted(nums)
    for i in range(1, size, 2) + range(0, size, 2):
        nums[x] = sNums.pop()
