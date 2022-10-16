from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord is None or len(endWord) == 0:
            return 0
        if beginWord not in wordList:
            wordList.append(beginWord)
        hashMap = dict()
        q = deque()
        q.append(beginWord)

        len_begin = len(beginWord)

        for i in range(len(wordList)):
            w = wordList[i]
            for j in range(len_begin):
                word = w[0: j] + "*" + w[j + 1: len_begin]
                l = hashMap.get(word, [])
                l.append(w)
                hashMap[word] = l

        visited = {}
        visited[beginWord] = True
        level = 0
        while q:
            level += 1
            for i in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return level
                for i in range(len_begin):
                    newWord = word[0: i] + "*" + word[i + 1: len_begin]
                    for adjWord in hashMap.get(newWord, []):
                        if adjWord not in visited:
                            visited[adjWord] = True
                            q.append(adjWord)
        return 0

# Graph, BFS
# Time Complexity:O(V+E)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


