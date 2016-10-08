/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    //O(N)
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));  //Push the list from end in order to start from beginning
        }
    }
    //Average O(1) time <= O(N)/N
    @Override
    public Integer next() {
        if(hasNext()){
            return stack.pop().getInteger();
        }
        return null;
    }
    //Worst case O(N) => average O(n)/n = O(1) time
    @Override
    public boolean hasNext() {  
        //Check for next integer and flatten the list among the way
        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();   //peek element in the top
            if(cur.isInteger()){    //Return true for integer
                return true;
            }
            //Flatten if list => POP the list out of stack and add everything back to the stack from end
            stack.pop();    
            for(int i=cur.getList().size()-1; i>=0; i--){
                stack.push(cur.getList().get(i));
            }
        }
        return false;   //Return false when stack is empty
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
