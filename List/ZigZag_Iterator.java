/*
Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
*/
//Use two iterator for each list
//Use a boolean flag to indicate which one is selected.
public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     */
    Iterator<Integer> t1;
    Iterator<Integer> t2;
    boolean turn;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        t1 = v1.iterator();
        t2 = v2.iterator();
        turn = false;
    }

    public int next() {
        // Write your code here
        if((turn == false && t1.hasNext()) || !t2.hasNext()){
            turn = true;
            return t1.next();
        }
        if((turn == true && t2.hasNext()) || !t1.hasNext()){
            turn = false;
            return t2.next();
        }
        return -1;
    }

    public boolean hasNext() {
        // Write your code here
        return t1.hasNext() || t2.hasNext();
    }
}



//For K Lists, use queue to store each iterator 
//each time call next poll iterator from front and add back to queue if hasNext()
//hasNext() return !queue.isEmpty()
//O(N) time complexity
public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        queue = new LinkedList<>();
        for(ArrayList list:vecs){
            if(!list.isEmpty()){
                queue.offer(list.iterator());
            }
        }
    }

    public int next() {
        // Write your code here
        Iterator<Integer> iter = queue.poll();
        int next = iter.next();
        if(iter.hasNext()){
            queue.offer(iter);
        }
        return next;
    }

    public boolean hasNext() {
        // Write your code here
        return !queue.isEmpty();
    }
}
