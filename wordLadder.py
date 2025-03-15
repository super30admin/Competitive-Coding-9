#Time Complexity :- O(n*l) n is number of words and l is lenght of each word
#Space Complexity :- O(n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        hashSet = set(wordList)
        if endWord not in hashSet:
            return 0
        q = deque([(beginWord,1)])
        while q:
            w,count = q.popleft()
            if w == endWord:
                return count
            for i in range(len(w)):
                for c in "abcdefghijklmnopqrstuvwxyz":
                    newWord = w[:i] + c + w[i+1:]
                    if newWord in hashSet:
                        q.append((newWord,count +1))
                        hashSet.remove(newWord)
        return 0