"""
Time Complexity : O(m^2 * n) where m is the length of each word and n is no. of words in wordList
Space Complexity : O(m^2 * n) where m is the length of each word and n is no. of words in wordList
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or beginWord == endWord:
            return 0
        possibilityMap = defaultdict(list)
        q = collections.deque([(beginWord, 1)])
        count = 1
        visit = {beginWord: True}
        # First we create a possibility map with all the possibilities of pattern
        # and create a list of strings that match those pattern
        for item in wordList:
            for i in range(len(item)):
                string = item[:i] + '?' + item[i+1:]
                possibilityMap[string].append(item)
        # We start by appending the beginWord and level 1 to the q and perform BFS
        # increment the level each time we find the matching string and return the 
        # level once we hit the endWord
        while q:
            curr, level = q.popleft()
            for i in range(len(beginWord)):
                    string = curr[:i] + '?' + curr[i+1:]
                    for item in possibilityMap[string]:
                        if item == endWord:
                            return level + 1
                        if item not in visit:
                            visit[item] = True
                            q.append((item, level + 1))
                    possibilityMap[string] = []
        return 0
                    
                       
        
                