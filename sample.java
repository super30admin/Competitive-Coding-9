// Time Complexity : O(n) where n max day of days array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP approach took time to come up with


// Your code here along with comments explaining your approach
/*
 * For each day we will check if we are traveling on that day
 * if yes, we will calculate value for all 3 choices. and take minimum value
 * if no, we simply copy value from previous location
 * To calculate value for 7day and 30day, we will subtract 7 and 30 from current processing day. if it goes to 0 or less than 0, we will consider costs[1] for 7day option and costs[2] for 30 day pass option as it will be valid
 * Else we take 7 + dp[i-7] and 30 + d[i-30] as 7 day and 30 day option as 7 and 30 day pass has expired for current day so we need to buy new one.
 * from these 3 values, we will choose min value for current processing day
 * finally, at last index, which is last traveling day, we will get min value required to travel till this day inclusive so we return that value
*/

class Solution {
    int result = Integer.MAX_VALUE;
    HashSet<Integer> travel_days;
    public int mincostTickets(int[] days, int[] costs) {
        
	//helper(days, 0, costs, 0,0, 0);
        //return result;
	
	travel_days = new HashSet<>();
        
	for(int i = 0; i < days.length;i++)travel_days.add(days[i]);
        
	int[] dp = new int[days[days.length-1]+1];
        
	for(int i = 1; i < dp.length;i++){
            if(travel_days.contains(i)){
                int valid2 = dp[i-1] + costs[0];
                int valid7 = costs[1];
                
		if(i - 7 > 0){
                    valid7 = valid7 + dp[i-7];
                }
                
		int valid30 = costs[2];
                if(i - 30 > 0){
                    valid30 = valid30 + dp[i-30];
                }
                
		dp[i] = Math.min(valid2, Math.min(valid7, valid30));
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
        
    }

	
    private void helper(int[] days, int index, int[] costs, int curr_cost, int valid_7days, int valid_30days){
        //base
        if(index == days.length){
            result = Math.min(result, curr_cost);
            return;
        }
        //logic
        //case1
        helper(days, index+1, costs, curr_cost + costs[0],valid_7days + 0, valid_30days + 0);
        //case2
        if(days[index] > valid_7days){
            helper(days, index+1, costs, curr_cost + costs[1], valid_7days + 7, valid_30days);
        }else{
            helper(days, index+1, costs, curr_cost, valid_7days, valid_30days);
        }
        //case3
        if(days[index] > valid_30days){
            helper(days, index+1, costs, curr_cost + costs[2],valid_7days, valid_30days + 30 );
        }else{
            helper(days, index+1, costs, curr_cost,valid_7days, valid_30days );
        }
    }
}
