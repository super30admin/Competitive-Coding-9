/** My solution 
   Time Complexity: O(N) where N is the number of days
   Space Complexity: O(N) where N is the number of days
**/


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        //base case
        if (days == null || costs == null)
				return 0;
		if (days.length == 0 || costs.length == 0)
				return 0;
        
        Set<Integer> hs = new HashSet<>();
        
        for(int day: days)
        {
           hs.add(day); 
        }
        
        int[] costArray = new int[366];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        
        costArray[0] = 0;
        
		for (int i = 1; i < 366; i++) {
                /* if a particular day is not travelled have the previous value in costArray */
			if (!hs.contains(i)) {
					costArray[i] = costArray[i - 1];
					continue;
				}
                /** Calculate all -day passes cost*/
				costArray[i] = Math.min(costArray[i], costArray[i - 1] + costs[0]);
                if(i-7 >=0)
                   costArray[i] = Math.min(costArray[i], costArray[i-7] + costs[1]); 
                else
                    costArray[i] = Math.min(costArray[i], costs[1]);
				
                if(i-30 >=0)
                   costArray[i] = Math.min(costArray[i], costArray[i-30] + costs[2]); 
                else
                    costArray[i] = Math.min(costArray[i], costs[2]);
                
            
        }
        return costArray[365];
        
    }
}
