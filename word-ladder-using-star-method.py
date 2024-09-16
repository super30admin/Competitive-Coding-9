
'''

Did it run on leetcode: Yes
Time Complexity: 0(N*N)
Space Complexity: 0(N)

Algorithm:
- Using BFS technique
- from startWord  add all words into the queue, which have only one character change.
- repeat the same for each word in queue till you get endWord or queue is empty.

'''



from collections import defaultdict
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        L = len(beginWord)
        all_words = defaultdict(list)
        
        for word in wordList:
            for i in range(L):
                all_words[word[:i]+"*"+word[i+1:]].append(word)
        
        
        queue = collections.deque([(beginWord,1)])
        visited ={beginWord:True}
        
        while queue:
            currentWord,level = queue.popleft()
            for i in range(L):
                intermediate = currentWord[:i]+"*"+currentWord[i+1:]
                for word in all_words[intermediate]:
                    if word==endWord:
                        return level+1
                    
                    if word not in visited:
                        visited[word]=True
                        queue.append((word,level+1))
            all_words[intermediate]=[]
        
        return 0;