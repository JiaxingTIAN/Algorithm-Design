#Peeking Iterator

>Design Pattern for iterator in java is Decorator serve as a wrapper class

A iterator support peek and getPrevious 

**Store the current and previous**
```java
class PeekIterator implements Iterator<Integer>{
    Iterator<Integer> iter;
    Integer pre;
    Integer tmp;
    public PeekIterator(Iterator<Integer> iter){
        this.iter = iter;
        if(iter.hasNext())
            tmp = iter.next();
    }
    @Override
    public boolean hasNext(){
        return tmp != null || iter.hasNext();
    }
    @Override
    public Integer next(){
        Integer next = tmp;
        pre = tmp;
        tmp = iter.hasNext()? iter.next():null;
        return next;
    }
    public Integer peek(){
        return tmp;
    }
    public Integer getPre(){
        return pre;
    }
}
```
#Flatten List Iterator ZigZag order
iterator to achieve next hasnext,flatten list 交替输出 [[7 8 9] 95[] [2 3 5] [1 19]] ---> 7 2 1 8 3 19
Use a queue to store the iterators of lists initialize with all the iterator of the nested lists
hasNext return if the queue is empty
next poll a iterator out of the queue and add back if it hasNext
```java
class FlattenIterator implements Iterator<Integer>{

     Queue<Iterator> queue;

     public FlattenIterator(List<List<Integer>> lists){
         queue = new LinkedList<>();
         for(List<Integer> cur:lists){
             if(cur!=null && !cur.isEmpty()){
                 queue.offer(cur.iterator());
             }
         }
     }

     public boolean hasNext(){
         return !queue.isEmpty();
     }

     public Integer next(){
         if(!hasNext())
             return null;
         Iterator<Integer> it = queue.poll();
         int next = it.next();
         if(it.hasNext()){
             queue.offer(it);
         }
         return next;
     }
 }
 ```
#Flatten List Iterator 
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =
```
[
  [1,2],
  [3],
  [4,5,6]
]
```
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

**ALG**

Implement use two iterator, one for the list of list, one for the current list

```java
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iterList;
    Iterator<Integer> iter;
    public Vector2D(List<List<Integer>> vec2d) {
        iterList = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(!hasNext())
            return null;
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        while((iter == null || !iter.hasNext()) && iterList.hasNext())
            iter = iterList.next().iterator();  //When iter is null or reach end keep find
        return iter != null && iter.hasNext();
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

#Merge Sorted Data Stream Iterator
Implement a iterator to output the sorted data stream in ascending order
Similar with PriorityQueue and wrapper iterator with peek 
compare the peek element of iterator and add to heap
```java
class StreamIterator implements Iterator<Integer>{
     Integer next;
     PeekIterator[] it;
     PriorityQueue<PeekIterator> hp;
     public StreamIterator(PeekIterator[] iterators){
         it = iterators;
         hp = new PriorityQueue<PeekIterator>(new Comparator<PeekIterator>(){
             public int compare(PeekIterator it1, PeekIterator it2){
                 return it1.peek() - it2.peek();
             }
         });
         for(PeekIterator iter:iterators){
             if(iter.hasNext())
                hp.offer(iter);
         }
     }
     @Override
     public Integer next(){
         PeekIterator pk = hp.poll();
         Integer tmp = pk.next();
         if(pk.hasNext())
             hp.offer(pk);
         return tmp;
     }
     @Override
     public boolean hasNext(){
         return !hp.isEmpty();
     }
 }
```
#BST Iterator 
1. Use a LinkedList, Space O(N) time O(1) 
  * inorder traverse first 
  * return and if the list is empty for hasNext
  * return remove(0)   
  
```java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    

    List<Integer> list;
     public BSTIterator(TreeNode root){

         list = new LinkedList<Integer>();
         Stack<TreeNode> stack = new Stack<>();
         //Inorder Traversal
         while(root != null || !stack.isEmpty()){
             while (root != null){
                 stack.push(root);
                 root = root.left;
             }
             TreeNode cur = stack.pop();
             list.add(cur.val);
             root = cur.right;
         }
         
     }

     public boolean hasNext(){
         return !list.isEmpty();
     }

     public Integer next(){
         if(!hasNext())
             return null;
         return list.remove(0);
     }

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 ```
 2. Use a stack, Space O(H) time O(1) average O(N)/N and O(H) for worst case
  * Push all left node of root onto stack when initalize
  * hasNext return stack empty
  * next return stack pop then push all left node of node.right to the stack

```java
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        push(root);
    }
    public void push(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        push(cur.right);
        return cur.val;
    }
}

 ```
 
