//TC - O(n) n is the max day given in days array
//SC - O(n) n is the max day given in days array
class Solution31 {
    public int mincostTickets(int[] days, int[] costs) {
        int dayslen = days.length-1;
        int[] dp = new int[days[dayslen]+1];
        dp[0]=0;
        int cost = 0;
        int idx =0;
        for(int i=1;i<dp.length;i++){
            if(i==days[idx]){
                //travel - 3 options
                int oneday = dp[i-1]+costs[0];                              //1 day pass = $2
                int sevenday = i-7>=0 ? dp[i-7]+costs[1] : costs[1];    //7 day pass = $7  
                int thirtyday = i-30>=0 ? dp[i-30]+costs[2] : costs[2]; //30 day pass = $15
                cost = Math.min(Math.min(oneday,sevenday),thirtyday);
                ++idx;
                dp[i]=cost;
            }
            else{
                //no travel
                dp[i]=cost;
            }
            System.out.println(cost);
        }
        return dp[dp.length-1];
    }
}
public class MincostTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2,7,15};
		Solution31 s = new Solution31();
		System.out.println(s.mincostTickets(days, costs));
	}

}
