# problem 1 


# https://leetcode.com/problems/word-ladder/description/

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        my_queue = deque([(beginWord,1)])
        while my_queue:
            word,level = my_queue.popleft()
            if word == endWord:
                return level
            for i in range(len(word)):
                for c in range(26):
                    ch = chr(ord('a')+c)
                    possible_word = word[:i]+ch+word[i+1:]
                    if possible_word in wordList:
                        wordList.remove(possible_word)
                        my_queue.append((possible_word,level+1))
        return 0