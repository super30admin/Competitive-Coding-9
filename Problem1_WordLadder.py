# Time Complexity: O(m^2 * n), where m - length of each word and n - number of words in the input word list
# Space Complexity: O(m^2 * n)

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord or not wordList or len(wordList) == 0:
            return 0

        L = len(beginWord)
        adj_dict = defaultdict(list)

        # Generate all possible patterns for every word and create pattern - word list mappings
        for word in wordList:
            for i in range(L):
                pattern = word[:i] + '*' + word[i + 1:]
                adj_dict[pattern].append(word)

        # Perform BFS to traverse from beginWord to endWord
        q = deque([(beginWord, 1)])
        visited = set(beginWord)

        while q:
            # For every word from the queue, check all its adj words (with one char diff)
            curr, level = q.popleft()
            for j in range(L):
                pattern = curr[:j] + '*' + curr[j + 1:]
                for adjword in adj_dict[pattern]:
                    # If endWord is reached, return the traversed distance
                    if adjword == endWord:
                        return level + 1
                    # Else, add it to the BFS queue and mark visited
                    if adjword not in visited:
                        visited.add(adjword)
                        q.append((adjword, level + 1))

        return 0