class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        #use buckets to indicate range, number can appear in neighbor buckets
        if t<0: 
            return False
        bucket = {} #dictionary for store bucket with corresponding num in nums
        w = t+1    #bucket size not fixed, to be t+1 for nums[i] nums[j] in same  
        for i in range(len(nums)):
            b = nums[i]/w
            if b in bucket:
                return True
            if b-1 in bucket and abs(nums[i] - bucket[b-1]) < w:
                return True
            if b+1 in bucket and abs(nums[i] - bucket[b+1]) < w:
                return True
            bucket[b] = nums[i]
            if i>=k:
                del bucket[nums[i-k]/w]
        return False
