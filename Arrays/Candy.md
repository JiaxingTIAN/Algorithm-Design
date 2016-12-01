# Give Candies

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.

Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

* Two pass with auxilary array
  1. Pass from left to right to make sure right with higher rate has more candy
  2. Pass from right to left to make sure left with higher rate has more candy
```java
public class Solution {
    public int candy(int[] ratings) {
        int[]can = new int[ratings.length];
        Arrays.fill(can, 1);
        int n = ratings.length;
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1])
                can[i] = can[i-1] + 1;
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                can[i] = Math.max(can[i], can[i+1] + 1);
        }
        int sum = 0;
        for(int c:can){
            sum += c;
        }
        return sum;
    }
}
```
