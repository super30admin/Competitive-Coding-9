'''
Solution:
1.  Perform a BFS from start word to end word with all words in the word list as intermediary node.
2.  One transformation creates one edge between two words.
3.  If the end word is reached after few levels of BFS traversal => return level; else return -1

Time Complexity:    O(k x N)    |   Space Complexity:   O(N)
k - average length of word in word list and N is number of words

--- Passed all testcases successfully on leetcode
'''


from collections import deque

class WordLadder:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        #   HashSet to store all words of word list for O(1) word check
        wordSet = set()

        #   fill the HashSet
        for i in range(len(wordList)):
            wordSet.add(wordList[i])

        #   initializations
        queue = deque([beginWord])
        level = 1

        #   iterate until queue is not empty
        while (len(queue) > 0):

            #   length of queue at current level
            n = len(queue)

            #   iterate for all words present in the queue at the current level
            for i in range(n):

                mainWord = queue.popleft()

                #   for current word -> find all possible substitutions and add to the queue
                #   only if present in HashSet; also remove from HashSet once added to the queue
                for i in range(len(mainWord)):
                    for j in range(26):
                        replacingChar = chr(ord('a') + j)
                        currWord = mainWord[:i] + replacingChar + mainWord[i + 1:]

                        #   condition to add to the queue
                        if (currWord in wordSet and mainWord[i] != replacingChar):
                            queue.append(currWord)
                            wordSet.remove(currWord)

                            #   if we find the end word => return next level
                            if (currWord == endWord):
                                return level + 1

            #   increment the level once the current level words in the queue are processed
            level += 1

        return 0
