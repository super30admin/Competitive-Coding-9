// Minimum Cost for Tickets
import java.util.*;
//tc - O(n) n - length of days array
//sc - O(n) set and dp araay

class Problem1{
    public static void main(String[] args){
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        Problem1 p = new Problem1();
        System.out.println(p.mincostTickets(days, costs));

    }
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0 || costs.length ==0){
            return 0;
        }
        //find max,
        //put all numbers in set
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i : days){
            max = Math.max(max, i);
            set.add(i);
        }
        int[] dp = new int[max+1];
        dp[0] = 0;
        for(int i = 1; i< dp.length; i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            int week = Math.max(i-7, 0);
            int month = Math.max(i-30, 0);
            dp[i] = Math.min(dp[i-1] + costs[0],
            Math.min(dp[week] + costs[1] , 
            dp[month] + costs[2]));

        }
        return dp[dp.length-1];
        

    }
}