/*
Time Complexity: O(3N), N is the number of days in the days array, and 3 times means, for each day we have three possibilities
Space Complexity: O(N), N is the length of the memoization array
Run on Leetcode: Yes
Any Difficulties: No

Approach:
1. I will be solving this problem using recursion, cause for every day, we have three possibilities,
I will make all the combinations for every possibility and try to find out minimum cost of travelling using that
 */
public class MinimumCostForTickets {
    public static int minimumCostOfTicket(int[] days, int[] costs){
        return getMinimumCostUsingRecursion(days, costs, 0, 0, new int[days.length]);
    }

    public static int getMinimumCostUsingRecursion(int[] days, int[] costs, int start, int travelDays, int[] memo){
        // base case
        if(start == days.length){
            return 0;
        }else if(days[start]<= travelDays){
            return getMinimumCostUsingRecursion(days, costs, start+1, travelDays, memo);
        }else if(memo[start]!= 0){
            return memo[start];
        }else{
            int minCost = Integer.MAX_VALUE;

            int oneDay = getMinimumCostUsingRecursion(days, costs, start+1, days[start]+0, memo)+costs[0];
            int sevenDays = getMinimumCostUsingRecursion(days, costs, start+1, days[start]+6, memo)+costs[1];
            int thirtyDays = getMinimumCostUsingRecursion(days, costs, start+1, days[start]+29, memo)+costs[2];

            minCost = Math.min(minCost, Math.min(oneDay, Math.min(sevenDays,thirtyDays)));

            memo[start] = minCost;
            return memo[start];
        }
    }
    public static void main(String[] args){
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println("Minimum Cost of Travel: "+ minimumCostOfTicket(days, costs));
    }
}
