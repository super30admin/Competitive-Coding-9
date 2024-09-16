# 127. Word Ladder

# Code:

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        # base case:
        if not beginWord or not endWord or not wordList:
            return 0
        
        length = len(beginWord)
        mapping = collections.defaultdict(list)
        
        for word in wordList:
            for i in range(length):
                new_comb = word[:i]+"*"+word[i+1:]
                mapping[new_comb].append(word)
        
        # BFS:
        q = collections.deque()
        visited = set()
        q.append((beginWord, 1))
        visited.add(beginWord)
        
        
        while q:
            current, level = q.popleft()
            # find all combinations and check mapping:
            for i in range(length):
                new_comb = current[:i]+"*"+current[i+1:]
                if new_comb in mapping:
                    for word in mapping[new_comb]:
                        if word==endWord:
                            return level+1
                        if word not in visited:
                            q.append((word, level+1))
                            visited.add(word)
                            
        return 0

# Time Complexity: O(length of the word * Number of words in the list)
# Space Complexity: O(length of the word * Number of words in the list)
# Accepted on LC: YES