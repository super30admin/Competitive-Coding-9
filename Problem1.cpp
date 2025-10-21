// Problem Name: Min cost to buy tickets
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. We create 1D  dp array to store the min cost to travel each day
// 2. We start filling our dp if the day is found in our days, otherwise we copy
// the previous state
// 3. For filling, we use the min cost to travel with all the passes available

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int mincostTickets(vector<int> &days, vector<int> &costs) {
    int lastD = days[days.size() - 1];
    vector<int> dp(lastD + 1, 0);
    // unordered_set<int> se(begin(days), end(days));
    int idx = 0;
    for (int i = 1; i <= lastD; i++) {
      if (days[idx] > i) {
        dp[i] = dp[i - 1];
      } else {
        idx++;
        dp[i] = min({
            dp[i - 1] + costs[0],
            dp[max(0, i - 7)] + costs[1],
            dp[max(0, i - 30)] + costs[2],
        });
      }
    }
    return dp[lastD];
  }
};
