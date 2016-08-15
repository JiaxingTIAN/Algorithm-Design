//Python
class Solution:
  def majorityElements(self, nums):
    if not nums: return[]
    count1, count2, can1, can2 = 0,0,0,1
    for n in nums:
      if n==can1:
        count1+=1
      elif n==can2:
        count2+-1
      elif count1==0:
        count1, can1 = 1, n
      elif count2==0:
        count2, can2 = 1, n
      else
        count1, count2 = count1-1, count2-1
    return [n for n in[can1, can2] if nums.count(n)> len(nums)//3]
    
