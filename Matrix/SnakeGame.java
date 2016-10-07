public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    //2D position info is encoded to 1D and stored as two copies 
    Set<Integer> set; // this copy is good for fast loop-up for eating body case
    Deque<Integer> body; // this copy is good for updating tail
    int[][] food;
    int foodIndex;
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0); //intially at [0][0]
        body = new LinkedList<>();
        body.offerLast(0);
    }
    
  
    public int move(String direction) {
        //case 0: game already over: do nothing
        if (foodIndex == -1) {
            return -1;
        }
        
        // compute new head
        int row = body.peekFirst() / width;
        int col = body.peekFirst() % width;
        switch (direction) {
            case "U" : row--;
                       break;
            case "D" : row++;
                       break;
            case "L" : col--;
                       break;
            case "R" : col++;
        }
        int head = row * width + col;
        
        //case 1: out of boundary or eating body
        set.remove(body.peekLast()); // new head is legal to be in old tail's position, remove from set temporarily 
        if (row < 0 || row == height || col < 0 || col == width || set.contains(head)) {
            return foodIndex = -1;
        }
        
        // add head for case2 and case3
        set.add(head); 
        body.offerFirst(head);
        
        //case2: eating food, keep tail, add head
        if (foodIndex < food.length && row == food[foodIndex][0] && col == food[foodIndex][1]) {
            set.add(body.peekLast()); // old tail does not change, so add it back to set
            return ++foodIndex;
        }
        
        //case3: normal move, remove tail, add head
        body.pollLast();
        return foodIndex;
        
    }
}
