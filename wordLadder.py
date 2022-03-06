"""
time: O (N)
space: O(N)
"""

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        dic = collections.defaultdict(list)
        wordList.append(beginWord)
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j]+ "*" + word[j+1:]
                dic[pattern].append(word)
        #use set so dont visit twice
        visit = (set([beginWord]))
        #use queue
        q = deque([beginWord])
        res = 1
        while q:
            for i in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return res
                for j in range(len(word)):
                    pattern = word[:j]+ "*" + word[j+1:]
                    for diW in dic[pattern]:
                        if diW not in visit:
                            visit.add(diW)
                            q.append(diW)
            res +=1
        return 0