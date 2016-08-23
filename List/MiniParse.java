/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s==null||s.length()==0) return new NestedInteger();
        if(s.charAt(0)!='[') return new NestedInteger(Integer.parseInt(s)); //just a single integer
        Stack<NestedInteger> stack = new Stack();
        NestedInteger cur = null;
        for(int l=0, r=0;r<s.length();r++){ //l indicate the start of the int substring, r is the end+1
            char c = s.charAt(r);
            if(c=='['){
                if(cur!=null)
                    stack.push(cur);
                cur = new NestedInteger();
                l = r+1;
            }
            else if(c==']'){
                String num = s.substring(l,r);
                if(!num.isEmpty())  //this is a number
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                if(!stack.isEmpty()){
                    NestedInteger parent = stack.pop();
                    parent.add(cur);
                    cur = parent;
                }
                l = r+1;
            }
            else if(c==','){
                if(s.charAt(r+1)!=']'){
                    String num = s.substring(l,r);
                    if(!num.isEmpty())  //this is a number
                        cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                l =r+1;
            }
        }
        return cur;
    }
}
