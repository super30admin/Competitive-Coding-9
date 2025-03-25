# https://leetcode.com/problems/word-ladder/


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        wordSet = set(wordList)
        q= deque()
        q.append(beginWord)

        level = 1
        while q:
            len_q = len(q)
            for _ in range (len_q):
                curr = q.popleft()

                if curr == endWord:
                    return level
                
                for i in range(len(curr)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if curr[i] == c:
                            continue
                        newWord = curr[:i] + c + curr[i+1:]

                        if newWord in wordSet:
                            q.append(newWord)
                            wordSet.remove(newWord)
            level += 1

        return 0
                        
#TC : O(n * L) queue and len(word)
# SC: O(n) for the set
