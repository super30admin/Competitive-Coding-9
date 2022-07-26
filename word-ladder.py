# Time Complexity: O(n*L) n is length of wordlist and L is length of beginword
# Space Complexity: O(n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wlist=set(wordList)
        if endWord not in wlist: return 0
        from collections import deque
        q=deque()
        q.append(beginWord)
        count=0
        vis=set()
        def words(word):
            ans=[]
            for i in range(0,len(word)):
                for j in range(26):
                    w=word[:i]+chr(ord('a')+j)+word[i+1:]
                    # print(w)
                    if w in wlist: ans.append(w)
            return ans               
        vis.add(beginWord)
        while len(q)!=0:
            s=len(q)
            count+=1
            for i in range(s):
                cur=q.popleft()
                li=words(cur)
                for l in li:
                    if l==endWord: return count+1
                    if l not in vis:
                        q.append(l)
                        vis.add(l)
        return 0
 