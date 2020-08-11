# breadth first search
# create every node as a node in the graph, find the distance between the nodes.
# if the distance between the current node and other node not in visited set is 1, add to the queue.
# and add the node to the visited set.
# if the current node is the end word, return the length of the sequence.
# else if the current node is not in the wordList, return 0.
# time complexity - O((nm)^2)
# space complexity - O(nm)   # n is the number of words, m is the length of each word.
# space taken by visited set - O(n*m) 
# space taken by the queue - O(n*m)
# did this code run on leetcode? - no (Time Limit Exceeded)

from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        n = len(wordList)
        if endWord not in wordList: # if the end word was not found in the list of words, return 0.
            return 0
        m = len(wordList[0])        # length of each word
        
        visited = set()
        visited.add(beginWord)
        
        q = deque()
        q.append((beginWord, 1))
        
        while q:
            currWord, currLen = q.popleft()
            
            if currWord == endWord:
                return currLen
            
            for nextWord in wordList:       # O(n)
                if nextWord not in visited and self.nodes_distance(currWord, nextWord, m): #O(m^2)
                    q.append((nextWord, currLen+1))
            
        return 0
        
    # Find the distance between the words.
    def nodes_distance(self, word1, word2, m):
        dist = 0
        for i in range(m):
            if word1[i] != word2[i]:
                dist+=1
        return dist==1
        
        
        
# maintain a dictionary of all wordForms of a word
# for every wordForm of the current word, visit all the nodes from the current node.
# if the word is the same as end word, return the length of sequence. Return 0, if end word is not reachable.
# time complexity - O(nm^2)
# space complexity - O(nm^2)   # n is the number of words, m is the length of each word.
# space taken by visited set - O(n*m) 
# space taken by the queue - O(n*m)
# space taken by the wordForms dictionary - O(n*m^2) - to save every word, we need space equal to the length of word. 
# did this code run on leetcode? - yes

from collections import deque, defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        n = len(wordList)
        if endWord not in wordList: # if the end word was not found in the list of words, return 0.
            return 0
        m = len(wordList[0])        # length of each word
        
        # create a dictionary of word patterns.
        wordForms = defaultdict(lambda: [])
        # O(nm) time
        for word in wordList:
            for i in range(m):
                pattern = word[:i] + "*" + word[i+1:]
                wordForms[pattern].append(word)
        
        # begin from the root and navigate till the end node.
        q = deque()
        visited = set()
        visited.add(beginWord)
        q.append((beginWord, 1))
        
        # O(nm) time
        while q:
            currWord, seqlen = q.popleft()
            if currWord == endWord:
                return seqlen
            
            for i in range(m):
                pattern = currWord[:i] + "*" + currWord[i+1:]
                for nextWord in wordForms[pattern]:
                    if nextWord not in visited: #O(m) -- depends on the length of the word
                        q.append((nextWord, seqlen+1))
                        visited.add(nextWord)
                
        return 0
            
    
# Bi-directional Breadth First Search (Solution from leetcode)
# time complexity - O(nm^2)
# space complexity - O(nm^2)   # n is the number of words, m is the length of each word.
# space taken by visited set - O(n*m) 
# space taken by the queue - O(n*m)
# space taken by the wordForms dictionary - O(n*m^2) - to save every word, we need space equal to the length of word. 
# did this code run on leetcode? - yes

from collections import deque, defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # if endWord not in wordList: # no need of this condition as the length of list is > 0 and begin, end words are always different.
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
            return 0
        
        # length of each word is the same.
        m = len(wordList[0])
        
        # create a dictionary of word patterns.
        self.wordForms = defaultdict(lambda: [])
        # O(nm) time
        for word in wordList:
            for i in range(m):
                pattern = word[:i] + "*" + word[i+1:]
                self.wordForms[pattern].append(word)
        
        # front and last queue to maintain the nodes queue.
        frontQ = deque([(beginWord, 1)])
        lastQ = deque([(endWord, 1)])
        
        # dictionary to maintain the index of the visited nodes from the front and back.
        visitedFront = { beginWord: 1 }
        visitedLast = { endWord: 1 }
        ans = None
        
        while frontQ and lastQ:      
            ans = self.shortestTransform(m, frontQ, visitedFront, visitedLast)
            if ans:
                return ans
        
            ans = self.shortestTransform(m, lastQ, visitedLast, visitedFront)
            if ans:
                return ans
            
            
        return 0
    
        
    def shortestTransform(self, m, queue, visited, otherVisited):
        node, step = queue.popleft()
        
        # append to the front queue.
        for i in range(m):
            pattern = node[:i] + "*" + node[i+1:]
            for word in self.wordForms[pattern]: # find the next states
                if word in otherVisited:    # if the new word is present in the other visited dictionary, return the value.
                    return step + otherVisited[word]
                if word not in visited:
                    queue.append((word, step+1))
                    visited[word] = step+1
        return None
    