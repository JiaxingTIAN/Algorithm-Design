public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null||cost == null||gas.length!=cost.length){
            return -1;
        }
        
        int n = gas.length;
        int total = 0;
        int start = 0;
        int tank = 0;
        
        for(int i=0; i<n; i++){
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(tank<0){
                //start from next station
                start = i+1;
                tank = 0;
            }
        }
        //if total balance is smaller than 0 -> unreachable
        if(total < 0)
            return -1;
        //Otherwise there must be a solution
        return start;
    }
}
