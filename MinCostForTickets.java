import java.util.HashSet;
//Time Complexity : O(D); where D is max day in days array which can go up to 365 in worst case
//Space Complexity : O(D)
public class MinCostForTickets {	
	/**Approach: DP array**/
	public int mincostTickets(int[] days, int[] costs) {        
        HashSet<Integer> set= new HashSet<>();
        int max= Integer.MIN_VALUE;
        for(int day: days){
            set.add(day);
            max= Math.max(max, day);
        }
                
        int[] dp= new int[max + 1];    
        dp[0]= 0;
        for(int i=1; i<dp.length; i++){
            if(!set.contains(i)){
                dp[i]= dp[i-1]; //If not a travel day
            }else{
            	//If Travel day, take min of (dp[i-1]+cost[0], dp[i-7]+costs[1], dp[i-30]+costs[2]
                dp[i]= Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(0,i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2]));
            }
        }
        return dp[dp.length-1];
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		MinCostForTickets ob = new MinCostForTickets();	
		//int[] days= {1,4,6,7,8,20};
		int[] days= {1,2,3,4,5,6,7,8,9,10,30,31};
		int[] costs= {2,7,15};		
		System.out.println("Min cost to travel is : "+ob.mincostTickets(days, costs));
	}
}
