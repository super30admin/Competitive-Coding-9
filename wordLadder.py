#Time Complexity O(M^2 * N) M->Number of works, N->Length of words
#Space Complexity O(M * N)

class Solution:
    def helper(self, curr):
        
        temp = list(curr)

        for i in range(len(curr)):
            char = temp[i]
            for j in range(26):
                temp[i] = chr(j+ord('a'))
                currStr = "".join(temp)
                if currStr in  self.wordListDict and self.wordListDict[currStr] != 0:
                    self.wordListDict[currStr] = 0
                    self.queue.append(currStr)
                    
            temp[i] = char
                    
                        
    
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if not wordList:
            return 0
        
        self.wordListDict = collections.Counter(wordList)
        self.wordListDict[beginWord] = 0
        self.queue = deque()
        self.queue.append(beginWord)
        distance = 0
        
        while self.queue:
            size = len(self.queue)
            for i in range(size):
                curr = self.queue.popleft()
                if curr == endWord:
                    return distance + 1
                self.helper(curr)
            distance += 1
        
        
        return 0
        
