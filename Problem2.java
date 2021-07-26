
// Time - O(N)
// Space - O(N)




class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int day : days) { // iterate through the days array and add it to the set each day

            max = Math.max(max,day); // calculating the max that would be the length of the dp array
            set.add(day);


        }

        int [] dp = new int[max + 1];

        for(int i = 1; i < dp.length; i++) {

            if(!set.contains(i)) {
                dp[i] = dp[i-1]; // if it does not contain then add previous val
            }
            else {

                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0,i-7)] + costs[1],dp[Math.max(0,i-30)] + costs[2])); // calculate minimum between 1 day, 7 day and 30 day

            }

        }


        return dp[dp.length - 1];



    }
}