''' Time Complexity : O(m * n) 
    Space Complexity : O(m * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        hashset = set(wordList)
        visited = set()
        level = 1
        q = deque()
        q.append(beginWord)
        while q:
            print(q)
            size = len(q)
            for k in range(size):
                word = q.popleft()
                for i in range(len(word)):
                    pre = word[0:i]
                    suf = word[i+1:]
                    for j in range(26):
                        charAt = chr(j+ord('a'))
                        newstr = pre + charAt + suf
                        print(newstr)
                        if newstr == endWord:
                            return level + 1
                        if newstr in hashset and newstr not in visited:
                            q.append(newstr)
                            visited.add(newstr)
            level += 1
        return 0

        