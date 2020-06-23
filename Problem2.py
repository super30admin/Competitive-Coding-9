# Time Complexity: O(m^2*n), m is the length of the words,n is the number of words in word list.

# Space Complexity:  O(m^2*n)

# Did it run on Leetcode?Yes

# Approach: We first make a dictionary in which keys will be one character replaced in the begin word and values will be the corresponding words from word list that can be formed by replacing that character index. Then we apply bfs and for that we use a queue. In this bfs, we will find the intermediate words which are nothing but the word that is formed by replacing a character.Children will be the values in the combo dictionary for this key word. To avoid repeated evaluations of the same word we maintain a visted dictionary. If the word is the end word then we return the level which will tell us how many steps it took us to reach this word from begin word. Else we will add the words of the this key from the dictionary to the queue and increment the level.

from collections import defaultdict, deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        if endWord not in wordset:
            return 0
        L = len(beginWord)
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(L):
                all_combo_dict[word[:i] + "*" + word[i + 1:]].append(word)

        queue = deque([(beginWord, 1)])
        visited = {beginWord: True}
        while queue:
            currentword, level = queue.popleft()
            for i in range(L):
                intermediate = currentword[:i] + "*" + currentword[i + 1:]
                for word in all_combo_dict[intermediate]:
                    if word == endWord:
                        return level + 1
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))
        return 0