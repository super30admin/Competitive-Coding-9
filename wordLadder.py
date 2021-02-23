# Time Complexity : O(MN)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        Brute force - O(N^2M) where N is the length of beginWord and M is number of elements in wordList
        
        BFS -> O(NM)?
        """
        if endWord not in wordList:
            return 0
        
        queue = deque([beginWord])
        count = 1
        seen = set()
        
        for i in range(len(wordList)):
            if wordList[i] not in seen:
                seen.add(wordList[i])
        
        while queue:
            size = len(queue)
            count += 1
            
            for i in range(size):
                currentString = queue.popleft()
                currentString = list(currentString)
                
                for letters in range(len(currentString)):
                    #should change each letter in every position
                    prev = currentString[letters]
                    #ascii numbers to change letter at current position
                    for alphabet in range(97, 123):
                        currentString[letters] = chr(alphabet)
                        #check if mutated string is in the set
                        if ''.join(currentString) in seen:
                            if ''.join(currentString) == endWord:
                                return count
                            seen.remove(''.join(currentString))
                            queue.append(''.join(currentString))
                    #since we are changing the string.. gotta revert it back to original state
                    currentString[letters] = prev

        return 0