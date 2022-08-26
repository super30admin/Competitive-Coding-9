//Time Complexity: O(2^n); where n is the length of days.
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_1 {

    int result = Integer.MAX_VALUE;
    
    public int mincostTickets(int[] days, int[] costs) {
        
        if(days == null||days.length == 0||costs == null||costs.length == 0)
            return -1;
        
        helper(days,costs,0,0,0);
        return result;
    }
    
    private void helper(int[] days, int[] costs, int index, int cost, int start)
    {
        if(index == days.length)
        {
            result = Math.min(result,cost);
            return;
        }
        
        else if(days[index] < start)
        {
            helper(days,costs,index+1, cost,start);
            return;
        }
        
        for(int i=0; i < costs.length; i++)
        {
            cost += costs[i];
            if(i == 0)
                start = days[index] + 1;
            else if(i == 1)
                start = days[index] + 7;
            else
                start = days[index] + 30;
            
            helper(days,costs,index+1, cost, start);
            cost -= costs[i];
        }
    }
}
