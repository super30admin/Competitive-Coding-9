
// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {  
    int min;  
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {  
        this.min = Integer.MAX_VALUE;  
        this.memo = new int[days.length];
        dfs(0, days, costs, 0);  
        return min;  
    }  
      
    private void dfs(int idx, int[] days, int[] costs, int total) {  
        // base case  
        if (idx == days.length) {  
            min = Math.min(min, total);  
            return;  
        }  
  
        if(memo[idx] !=0){
           min= Math.min(min, total + memo[idx]); 
            return;
        }
        // logic  
        dfs(idx + 1, days, costs, total + costs[0]);  
          
        int nIdx = idx;  
        while (nIdx < days.length && days[nIdx] < days[idx] + 7) {  
            nIdx++;  
        }  
        dfs(nIdx, days, costs, total + costs[1]);  
  
        nIdx = idx;  
        while (nIdx < days.length && days[nIdx] < days[idx] + 30) {  
            nIdx++;  
        }  
        dfs(nIdx, days, costs, total + costs[2]);  
        
        memo[idx] = min- total;
        
    }  
}  
