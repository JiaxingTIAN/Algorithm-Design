class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        count, res = 0, []
        adj = {i:[] for i in xrange(numCourses)}
        degree = [0]*numCourses
        for x,y in prerequisites:
            adj[y].append(x)
            degree[x]+=1
        queue = collections.deque([i for i in xrange(numCourses) if degree[i]==0])
        while queue:
            node = queue.popleft()
            count+=1
            res.append(node)
            for course in adj[node]:
                degree[course]-=1
                if degree[course]==0:
                    queue.append(course)
        return res if count==numCourses else[]
