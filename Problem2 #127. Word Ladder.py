# Time Complexity:    O(k x N)    # k - average length of word in word list and N is number of words
# Space Complexity:   O(N)

from collections import deque

class WordLadder:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set()
        for i in range(len(wordList)):
            wordSet.add(wordList[i])

        queue = deque([beginWord])
        level = 1

        while (len(queue) > 0):
            n = len(queue)
            for i in range(n):
                mainWord = queue.popleft()
                for i in range(len(mainWord)):
                    for j in range(26):
                        replacingChar = chr(ord('a') + j)
                        currWord = mainWord[:i] + replacingChar + mainWord[i + 1:]
                        if (currWord in wordSet and mainWord[i] != replacingChar):
                            queue.append(currWord)
                            wordSet.remove(currWord)
                            if (currWord == endWord):
                                return level + 1
            level += 1

        return 0
