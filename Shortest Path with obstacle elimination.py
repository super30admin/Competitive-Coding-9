# Time Complexity : O(m*n*k)
# Space Complexity : O(m*n*k)
# The code ran on LeetCode
# Use a 3d visited array to keep track of how many obstacles were passed to reach a particular cell. BFS to get the minimum number of steps required to reach the destination

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        m = len(grid); n = len(grid[0])
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visited = [[[False for _ in range(k+1)] for _ in range(n)] for _ in range(m)]
        q = deque()
        q.append((0, 0, k)); visited[0][0][k] = True
        result = 0
        while q:
            size = len(q)
            for _ in range(size):
                cur = q.popleft()
                x = cur[0]; y = cur[1]
                if x == m-1 and y == n-1:
                    return result
                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy
                    if nx >= 0 and ny >= 0 and nx < m and ny < n:
                        K = cur[2] - grid[nx][ny]
                        if K >= 0 and visited[nx][ny][K] == False:
                            q.append((nx, ny, K))
                            visited[nx][ny][K] = True

            result += 1
        return -1