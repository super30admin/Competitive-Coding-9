"""
# Approach: The intuition is that at each index, we have three options either take day 1 pass, day 7 or day 30.
# if we choose 7 or 30 day pass, we will cover consecutive 7/30 days from that index to further, at each index
# we choose the minimum cost which will occur from that index to end and store for memoization

Time Complexity: O(n) - > O(3^n) if not memo
Space : O(n)
"""


class Solution:
    def mincostTickets(self, days, costs):
        memo = {}
        def helper(i):
            if i >= len(days):
                return 0
            if i in memo:
                return memo[i]
            min_1 = costs[0] + helper(i+1)
            j, k = i, i
            while j < len(days) and days[j] < days[i] + 7:
                j += 1
            min_7 = costs[1] + helper(j)
            while k < len(days) and days[k] < days[i] + 30:
                k += 1
            min_30 = costs[2] + helper(k)
            
            min_cost = min(min_1, min_7, min_30)
            memo[i] = min_cost
            return memo[i]
        return helper(0)

def main():
    sol = Solution()
    test_cases = [
        # Format: (days, costs, expected)
        ([1, 4, 6, 7, 8, 20], [2, 7, 15], 11),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31], [2, 7, 15], 17),
        ([1, 3, 5, 7, 12, 20, 30], [3, 8, 20], 17),
        ([1], [2, 5, 10], 2),
        ([1, 2, 3, 4, 5, 6, 7], [2, 7, 15], 7)
    ]

    for i, (days, costs, expected) in enumerate(test_cases, 1):
        result = sol.mincostTickets(days, costs)
        print(f"Test Case {i}: Days = {days}, Costs = {costs}")
        print(f"Expected = {expected}, Got = {result} → {'PASS' if result == expected else 'FAIL'}\n")


if __name__ == "__main__":
    main()
