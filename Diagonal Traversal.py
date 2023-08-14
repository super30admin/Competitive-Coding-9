# Time Complexity : O(number of elements in nums)
# Space Complexity : O(number of elements in nums), since the hash map comtains all elements
# The code ran on LeetCode
# Maintain a Hash map that maps sum of x, y indices to a list of numbers. Traverse nums in reverse order and append elements to the hash map.
class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        m = len(nums)
        hash_map = {}; max_idx = 0
        for i in range(m-1, -1, -1):
            cur = nums[i]
            for j in range(len(cur)):
                idx = i + j
                hash_map[idx] = hash_map.get(idx, [])
                hash_map[idx].append(cur[j])
                max_idx = max(idx, max_idx)
        res = []
        for i in range(max_idx + 1):
            for val in hash_map[i]:
                res.append(val)
        return res