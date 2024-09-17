// Time Complexity : O(m+1) m is the highest day in days array
// Space Complexity : O(1) we know that the limit to the days is 365.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//We can solve it by using Dynamic Programming.
// create output matrix with the size of out highest day+1 and a set for storing the needed days to find the cost.
// start iteration from 1 till length of output, copy the previous index to maintain our cost till now.
// if the set contains the number, calculate costs. If week pass how much, month pass how much and day pass how much.
// get the minimum of all of those costs and store it in output array with that day index.
// Likewise, by minimmising the cost at every step, we get the desired minimum cost for travel at the end of output array iteration (Last Day).

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int max = days[days.length-1];
        int[] output = new int[max+1];

        HashSet<Integer> set = new HashSet<>();

        for(int num: days) {
            set.add(num);
        }

        for(int i=1; i<output.length; i++) {
            int number = i;
            output[i] = output[i-1];
            if(set.contains(number)) {

                int week = output[Math.max(i-7,0)]+costs[1];
                int month = output[Math.max(i-30,0)]+costs[2];
                int day = output[i-1]+costs[0];

                output[i] = Math.min(day,Math.min(week,month));
            }
        }
        return output[output.length-1];
    }
}
