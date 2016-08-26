class Solution(Object):
  def kthSmallest(self, matrix, k):
    heap, res = [(row[0],row, 1) for row in matrix], 0
    heapq.heapify(heap)
    for _ in xrange(k):
      res, r, c = heapq.heappop(heap)
      if c<len(r):
        heapq.heappush(heap, (r[c], r, c+1)
    return res
      
