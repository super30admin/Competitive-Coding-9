# // Time Complexity : O(m*n^2) where m is the length of a word and 
# n is the number of words in the wordlist
# // Space Complexity : O(m*n^2)
# // Did this code successfully run on Leetcode : 
# // Any problem you faced while coding this : 

# // Your code here along with comments explaining your approach 
class Solution:
    
    def get_adjacent_words(self,word):
        res = []
        for i in range(len(word)):
            s = word[:i] + '_' + word[i+1:]
            res.append(s)
        return res    
                
                
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not wordList: return 0
        wordDict = defaultdict(list)
        
        for word in wordList:
            adj_words = self.get_adjacent_words(word)
            for each in adj_words:
                wordDict[each].append(word)
        
        # print(wordDict) 
        
        # BFS routine
        
        queue = deque()
        queue.append((beginWord,1))
        visited = set()
        visited.add(beginWord)
     
        while queue:
            word,level = queue.popleft()
            if word == endWord: return level
            adj_words = self.get_adjacent_words(word)
            for each in adj_words:
                for list_words in wordDict[each]:
                    if list_words not in visited:
                        queue.append((list_words,level+1))
                        visited.add(list_words)
        return 0
        