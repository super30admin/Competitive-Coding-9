// // Recursive TLE O(3^n) time, O(n) space
// class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//         return helper(0, days, costs);
//     }

//     private int helper(int i, int[] days, int[] costs) {
//         int n = days.length;
//         if (i >= days.length) {
//             return 0;
//         }

//         int daysTraveled = i;
//         while (daysTraveled < n && days[daysTraveled] < days[i] + 1) {
//             daysTraveled++;
//         }
//         int oneDay = helper(daysTraveled, days, costs) + costs[0];

//         while (daysTraveled < n && days[daysTraveled] < days[i] + 7) {
//             daysTraveled++;
//         }
//         int sevenDays = helper(daysTraveled, days, costs) + costs[1];

//         while (daysTraveled < n && days[daysTraveled] < days[i] + 30) {
//             daysTraveled++;
//         }
//         int thirtyDays = helper(daysTraveled, days, costs) + costs[2];

//         return Math.min(oneDay, Math.min(sevenDays, thirtyDays));
//     }
// }


// Memo O(n) time, O(n) space

import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(0, days, costs, dp);
    }

    private int helper(int i, int[] days, int[] costs, int[] dp) {
        int n = days.length;
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] != -1) return dp[i];

        int daysTraveled = i;
        while (daysTraveled < n && days[daysTraveled] < days[i] + 1) {
            daysTraveled++;
        }
        int oneDay = helper(daysTraveled, days, costs, dp) + costs[0];

        while (daysTraveled < n && days[daysTraveled] < days[i] + 7) {
            daysTraveled++;
        }
        int sevenDays = helper(daysTraveled, days, costs, dp) + costs[1];

        while (daysTraveled < n && days[daysTraveled] < days[i] + 30) {
            daysTraveled++;
        }
        int thirtyDays = helper(daysTraveled, days, costs, dp) + costs[2];

        return dp[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
}