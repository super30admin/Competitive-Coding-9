// Time Complexity : O(n)
// Space Complexity : O(366) => O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution 
{
    public int mincostTickets(int[] days, int[] costs) 
    {
        int[] spent = new int[366];
        int si = 0;

        for(int i=1;i<=365;i++) {

          if(i!=days[si]) {
            spent[i] = spent[i-1];
          }
          else {

            int cost1days = costs[0] + spent[i-1];
              
            int tempCost = (i-7)<0?0:spent[i-7];
            int cost7days = costs[1] + tempCost;
            
            tempCost = (i-30)<0?0:spent[i-30];
            int cost30days = costs[2] + tempCost;

            spent[i] = Math.min(Math.min(cost1days,cost7days), cost30days);
            si++;
            if(si==days.length) return spent[i];
          }

        }
        return spent[365];

    }
}
