// Time complexity - O(n^2)
// Space complexity - O(n)
// Solved on leetcode - yes
// faced any issues - nO
class Solution {
    int[] memo;
    int[] duration = {1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        memo = new int[n];
        Arrays.fill(memo, -1); // mark uncomputed states
        return helper(days, costs, 0, days.length, 0);
    }

    public int helper(int[] days, int[] costs, int pivot, int n, int currentSum) {
        if (pivot == n) return currentSum;

        if (memo[pivot] != -1) return currentSum + memo[pivot];

        int c1 = helper(days, costs, getIndex(pivot, days[pivot] + 1, days), n, currentSum + costs[0]);
        int c2 = helper(days, costs, getIndex(pivot, days[pivot] + 7, days), n, currentSum + costs[1]);
        int c3 = helper(days, costs, getIndex(pivot, days[pivot] + 30, days), n, currentSum + costs[2]);

        int min = Math.min(c1, Math.min(c2, c3));
        memo[pivot] = min - currentSum; // store only the remaining cost from this pivot
        return min;
    }

    public int getIndex(int currentIndex, int value, int[] days) {
        for (int i = currentIndex; i < days.length; i++) {
            if (days[i] >= value) return i;
        }
        return days.length;
    }
}
