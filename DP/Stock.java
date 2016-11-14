public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int hold = Integer.MAX_VALUE;
        int sell = 0;
        for(int p:prices){
            hold = Math.min(hold, p);
            sell = Math.max(sell, p-hold);
        }
        return sell;
    }
}
