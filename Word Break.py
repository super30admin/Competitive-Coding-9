# TC: O(n * n * (m*26) ) = O(n^2 * n) where n = no. of words, m = length of the words
# SC: O(n*m) for the queue
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        m = len(beginWord)
        n = len(wordList)
        
        h = set(wordList)
        
        q = collections.deque()
        q.appendleft(beginWord)
        ans = 0
        
        while(q): # O(n)
            
            size = len(q)
            ans += 1
            for i in range(size): # O(n)
                curr = q.pop()
                print(curr)
                if curr == endWord:
                    return ans
                
                currList = list(curr)
                print(currList)
                
                for j in range(len(currList)): #O(m)
                    temp = currList[j]
                    for k in range(ord('a'),ord('z')+1): #O(26)
                        if chr(k)!= temp:
                            currList[j] = chr(k)

                            word = "".join(currList)
                            print(word)

                            if word in h:
                                q.appendleft(word)
                                h.remove(word)
                    currList[j] = temp
        
        return 0
        