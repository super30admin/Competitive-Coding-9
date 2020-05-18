// Time Complexity : O(max(days))
// Space Complexity : O(max(days))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //edge case
        if(days==null || days.length == 0) return  0;
        HashSet<Integer> set = new HashSet<>();
        
        int max = Integer.MIN_VALUE;
        for(int day:days)
        {
            set.add(day);
            max = Math.max(max,day);
        }
        int[] memo  = new int[max+1];
        for(int i = 1 ; i <memo.length;i++)
        {
            if(!set.contains(i))
            {
                memo[i]=memo[i-1];
            }
            else
            {
            memo[i] = Math.min(Math.min(memo[i-1]+costs[0],i-7>=0?memo[i-7]+costs[1]:costs[1]),i-30>=0?memo[i-30]+costs[2]:costs[2]); 
            }
        }
         return memo[max];
    }
}