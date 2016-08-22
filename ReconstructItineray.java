public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> v = new HashMap();
        for(String[] str:tickets){
            if(!v.containsKey(str[0]))
                v.put(str[0], new PriorityQueue<String>((s1,s2)->(s1.compareTo(s2))));
            v.get(str[0]).add(str[1]);
        }
        List<String> res = new LinkedList();
        String start = "JFK";
        //dfs(tickets, res, v, start);
        Stack<String> stack = new Stack();
        stack.push(start);
        while(!stack.isEmpty()){
            while(v.containsKey(stack.peek()) && !v.get(stack.peek()).isEmpty())
                stack.push(v.get(stack.peek()).poll());
            res.add(0, stack.pop());
        }
        return res;
    }
    
    
    public void dfs(String[][]tickets, List res, Map<String, PriorityQueue<String>> v, String start){
        while(v.containsKey(start) && !v.get(start).isEmpty()){
            dfs(tickets, res, v, v.get(start).poll());
        }
        res.add(0, start);
    }
}
