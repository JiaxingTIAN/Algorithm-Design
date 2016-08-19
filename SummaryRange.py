class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        res, i = [], 0
        if len(nums)==1: return [str(nums[0])]
        while i<len(nums):
            a = nums[i]
            while i+1<len(nums) and nums[i+1]-nums[i]==1:
                i+=1
            if a==nums[i]: 
                res.append(str(a))
            else: 
                s = str(a)+"->"+str(nums[i])
                res.append(s)
            i+=1
        return res
