// Time Complexity : O(n) n is max day
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a map of all travel days as true
create a dp array of n+1 elements where n is the last day
loop over dp and if its not a travel day set its value to previous value and return
else get day value as dp[i-1 or 0] + cost of day
week value as dp[i-7 or 0] + cost of week
month value as dp[i-30 or 0] + cost of month
current value will be min of the 3
return dp[n]
*/
package main

import "fmt"

func mincostTickets(days []int, costs []int) int {
	n := days[len(days)-1]
	dp := make([]int, n+1)
	M := make(map[int]bool)
	for _, v := range days {
		M[v] = true
	}
	for i := 1; i < len(dp); i++ {
		if !M[i] {
			dp[i] = dp[i-1]
			continue
		}
		one := dp[i-1] + costs[0]
		seven := dp[max(i-7, 0)] + costs[1]
		thirty := dp[max(i-30, 0)] + costs[2]
		dp[i] = min(one, seven, thirty)
	}
	return dp[n]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(arr ...int) int {
	a := arr[0]
	for _, v := range arr {
		if v < a {
			a = v
		}
	}
	return a
}

func MainMinCostTicket() {
	fmt.Println(mincostTickets([]int{1, 4, 6, 7, 8, 20}, []int{2, 7, 15})) // expected 11
}
