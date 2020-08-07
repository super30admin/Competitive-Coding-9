# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method 1) Using dictionries and mapping the newword and the list till the endword. 
# Time = O(n) where n are the number of words in wordList | Space = O(n) for visited array
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList or len(wordList) == 0 :
            return 0 
        wordList = set(wordList)
        dict1 = collections.defaultdict(list)
        dict1[beginWord] = [[beginWord]]
    
        while dict1:
            dict2 = collections.defaultdict(list)
            for word in dict1:
                if word == endWord:
                    max_ = float('inf')
                    for listt in dict1[word]:
                        max_ = max(max_, len(listt))
                    
                    return max_ 
                
                for i in range(len(word)):
                    for char in 'abcdefghijklmnopqrstuvwxyz':
                        newWord = word[:i] + char + word[i+1:]
                        if newWord in wordList:
                            dict2[newWord] += [[word] + subArray for subArray in dict1[word]]
            dict1 = dict2 
            wordList -= set(dict2.keys())
        return 0 

# Method 2) Using BFS approach.
# Time = O(n) where n are the number of words in wordList | Space = O(n) for visited array
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        q = [(beginWord, 1)]
        visited = set()
        wordList = set(wordList)
        while len(q) > 0:
            word, dist = q.pop(0)
            if word == endword:
                return dist 
            
            for i in range(len(word)):
                for char in 'abcdefghijklmnopqrstuvwxyz':
                    temp = word[:i] + char + word[i+1:]
                    if temp not in visited and temp in wordList:
                        q.append((temp, dist+1))
                        visited.add(temp)
        return 0
            
            
        

if __name__ == "__main__":
    s = Solution()
    beginword = "hit"
    endword = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    print(s.ladderLength(beginword, endword, wordList))