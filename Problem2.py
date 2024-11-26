# 127. Word Ladder
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        patternMap = {}
        wordList.append(beginWord)

        if endWord not in wordList:
            return 0
        if beginWord == endWord:
            return 1

        for word in wordList:
            for j in range(len(word)):
                pattern = word[0:j] + "*" + word[j+1:]
                if pattern not in patternMap:
                    patternMap[pattern] = []
                patternMap[pattern].append(word)

        visited = set([beginWord])
        q = deque([beginWord])
        result = 1

        while q:
            for i in range(len(q)):
                word = q.popleft()
                if word == endWord: return result
                for j in range(len(word)):
                    pattern = word[0:j] + "*" + word[j+1:]
                    if pattern in patternMap:
                        for nei in patternMap[pattern]:
                            if nei not in visited:
                                visited.add(nei)
                                q.append(nei)
            result += 1

        return 0
            

        

