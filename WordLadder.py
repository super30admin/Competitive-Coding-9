--------------------------find the window which contais all the characters ------------------------------------------
# Time Complexity : O(M**2XN) as M is length of word and n number of total words
# Space Complexity : O(M**2XN) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I will take the temporary word to make a all combo dict d and we start with the begin word and iterate level by level
#as we have all characters differ by 1 char. Using BFS we start with beginword and level as 1, and in each iteration we will check if popped word 
# from queue is end word, else we will check the temp word from current word and add all the words from dict to queue with increasing level by 1.


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if not beginWord or not endWord or endWord not in wordList:
            return 0
        
        d = collections.defaultdict(list)
        
        for word in wordList:
            for i in range(len(word)):
                temp = word[:i]+'*'+word[i+1:]
                d[temp].append(word)
        
        queue = collections.deque()
        queue.append((beginWord, 1))
        visited = set()
        visited.add((beginWord))
        while queue:
            curr, level = queue.popleft()
            
            if curr == endWord:
                return level
            
            for i in range(len(curr)):
                temp = curr[:i]+'*'+curr[i+1:]
                for j in d[temp]:
                    if j not in visited:
                        visited.add(j)
                        queue.append((j, level+1))
        return 0