# TC: O(N*K*K), N: length of wordList, K: length of each word
# SC: O(N)

import collections
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        
        if not beginWord or not endWord or endWord not in wordList:
            return 0
             
        dic = collections.defaultdict(list)
        
        for word in wordList:
            for i in range(len(word)):
                inter = word[:i] + "*" + word[i+1:]
                dic[inter].append(word)
        #print(dic)
        
        queue = collections.deque([(beginWord,1)])
        visited = set()

        while queue:
            print(queue)
            word,length = queue.popleft()
            
            if word==endWord:
                return length
            print(word,length)
            
            for i in range(len(word)):
                inter = word[:i] + "*" + word[i+1:]
                for w in dic[inter]:
                    if w not in visited:
                        
                        queue.append((w,length+1))
                        visited.add(w)
                dic[inter] = []
                    
        return -1