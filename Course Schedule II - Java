public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];int k=0; //store the resulting topological sort array
        int[] degree = new int[numCourses]; //record the num of prerequisites need for the course to be taken
        List<List<Integer>> adj = new ArrayList();  //adjecency list
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<Integer>());    //add adjecency list to each node
        for(int[] p:prerequisites){
            degree[p[0]]++;
            adj.get(p[1]).add(p[0]);//The node is prerequisites easy to search
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0)
                q.add(i);   //add the ready course to the queue, which is the prerequisites of other courses
        }
        while(!q.isEmpty()){
            int j = q.remove();
            result[k++] = j;
            numCourses--;
            for(int course:adj.get(j)){
                degree[course]--;   //get all the courses with that prerequisites and reduce the degree
                if(degree[course]==0){
                    q.add(course);  //if no more prerequisites for that course, add it to the queue.
                }
            }
        }
        return numCourses==0? result:new int[0];
    }
}
