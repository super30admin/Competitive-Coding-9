//TC = O(N)
//SC = O(N)

public class MinimumCostForTickets{

    public static int minCostTickets(int[] days, int[] costs)
    {
        int[] dp = new int[366];

        dp[0]=0;

        int j =0;
        for(int i =1;i<=365;i++)
        {
            if(j==days.length)
            {
                break;
            }

            if(days[j]!=i)
            {
                dp[i]=dp[i-1];
            }
            else
            {
                int one = costs[0] + dp[i-1];
                int seven = costs[1] + dp[Math.max(0, i-7)];
                int thirty = costs[2] + dp[Math.max(0, i-30)];
                
                dp[i] = Math.min(one, Math.min(seven, thirty));
                
                j++;
            }
        }
        
        
        return dp[days[days.length-1]];
    }

    public static void main(String args[])
    {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        System.out.println(minCostTickets(days, costs));
    }

}