class MinimumCostforTickets {
    public int mincostTickets(int[] days, int[] costs) {
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper(days,0,costs,memo);
    }

    private int  helper(int[] days,int idx,int[] costs, HashMap<Integer, Integer> memo)
    {
        if(idx>=days.length)
        return 0;

            int n= days.length;

            if(memo.containsKey(idx))
            return memo.get(idx);
            //choose 1 day
            int singleDayCost = costs[0]+helper(days,idx+1,costs,memo);
            

            //choose 7 days pass
            int weekfromStart = days[idx]+7;
            int weekIdx = idx;
            while(weekIdx<n && days[weekIdx]<= weekfromStart-1)
            {
                weekIdx++;
            }
           int weekPassCost= costs[1]+helper(days,weekIdx,costs,memo);


            //chosse 30 days pass
            int monthPassCost = Integer.MAX_VALUE;
            if(idx < n)
            {
            int monthPassDays = days[idx]+30;
            int monthIdx = idx;
            while(monthIdx<n && days[monthIdx]<= monthPassDays-1)
            {
                monthIdx++;
            }
            monthPassCost = costs[2]+helper(days,monthIdx,costs,memo);
            }

           int minCost = Math.min(singleDayCost,Math.min(weekPassCost,monthPassCost));
           memo.put(idx,minCost);

           return minCost;
    }
}

//TC: O(n), n is the length of the days array
//SC: O(n)