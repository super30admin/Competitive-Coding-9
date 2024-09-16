// Time - O(N)
// Space - O(N)

class Solution {
    
    Integer[] memo;
    HashSet<Integer> set;
    public int mincostTickets(int[] days, int[] costs) {
        
        memo = new Integer[366];
        set = new HashSet<>();
        for(int d : days) {
            set.add(d);
        }
        
        return helper(1, costs);
        
    }
    
    private int helper(int index, int[] costs) {
        if(index>365) {
            return 0;
        }
        
        if(memo[index]!=null) {
            return memo[index];
        }
        if(set.contains(index)) {
            return Math.min(costs[0] + helper(index+1, costs), Math.min(costs[1] + helper(index+7, costs), costs[2] + helper(index+30, costs)));        
        }
        else {
            return helper(index+1, costs);
        }
    }
    
}
