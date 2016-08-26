import java.util.Comparator;  
import java.util.PriorityQueue;  
import java.util.Queue; 

class Node {
    public int value, from_id, index;
    public Node(int _v, int _id, int _i) {
        this.value = _v;
        this.from_id = _id;
        this.index = _i;
    }
}

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        Queue<Node> queue =  new PriorityQueue<Node>(k, new Comparator<Node>() {  
                public int compare(Node o1, Node o2) {  
                    if (o1.value > o2.value)
                        return -1;
                    else if (o1.value < o2.value)
                        return 1;
                    else
                        return 0;
                }
            }); 

        int n = arrays.length;
        int i;
        for (i = 0; i < n; ++i) {
            Arrays.sort(arrays[i]);
            
            if (arrays[i].length > 0) {
                int from_id = i;
                int index = arrays[i].length - 1;
                int value = arrays[i][index];
                queue.add(new Node(value, from_id, index));
            }
        }

        for (i  = 0; i < k; ++i) {
            Node temp = queue.poll();
            int from_id = temp.from_id;
            int index = temp.index;
            int value = temp.value;
            
            if (i == k - 1)
                return value;
            
            if (index > 0) {
                index --;
                value = arrays[from_id][index];
                queue.add(new Node(value, from_id, index));
            }
        }

        return -1;
    }
}
