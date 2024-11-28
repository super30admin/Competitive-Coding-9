#Time Complexity: O(M^2*N)
#Space Complexity: O(M^2*N)

from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        queue = deque()
        queue.append(beginWord)
        level = 1
        visited = set()
        visited.add(beginWord)
        while(queue):
            for i in range(len(queue)):
                popped = queue.popleft()
                if popped== endWord:
                    return level
                for word in wordList:
                    if word not in visited:
                        count = 0
                        flag = True
                        for index,letter in enumerate(word):
                            if letter!=popped[index]:
                                count+=1
                            if count >1:
                                flag = False
                                break
                        if flag:
                            queue.append(word)
                            visited.add(word)


            level+=1
        return 0
                      