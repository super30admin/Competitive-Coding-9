# TC: O(n*L)
# SC: O(n*L)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set()
        seen = set()
        begin=0
        for char in beginWord:
            begin= begin*26 + ord(char) - 97
        
        end=0
        for char in endWord:
            end= end*26 + ord(char) - 97
        
        for word in wordList:
            rh=0
            for char in word:
                rh = rh*26 + ord(char) - 97
            
            wordSet.add(rh)
        
        if end not in wordSet:
            return 0
        
        wordLen = len(endWord)
        seen.add(begin)
        q = deque([begin])
        res=0
        while q:
            res+=1
            size = len(q)
            for _ in range(size):
                wordH = q.popleft()
                for k in range(wordLen):
                    rh = wordH - (26**k)*(wordH%(26**(k+1))//(26**k))
                    for charH in range(26):
                        nh = rh + (26**k)*charH
                        if nh not in seen and nh in wordSet:
                            if nh==end:
                                return res+1
                            seen.add(nh)
                            q.append(nh)
        
        return 0



