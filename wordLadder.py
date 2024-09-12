'''
Time Complexity: O(n*m) n is number of words and m is length of word
Space Complexity: O(n*m)
Did this code successfully run on Leetcode : Yes
Explanation: Create a dictionary with all possible permutations of words as key and the actual word in a list for eg
w*g = [wag, wig] etc and use BFS to go through this dictionary and search for these permutations from the original
word permutations. for eg if input word is wug, we find alternate permutations of this such as w*g, *ug and wu*.
we can see that w*g contains 2 more nodes wag and wig, we select one of these add it to queue and generate these words
again until we reach the end word.
'''


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or beginWord is None:
            return 0

        length = len(beginWord)

        wordDict = {}

        for word in wordList:
            for j in range(0, length):
                subWord = word[0:j] + '*' + word[j + 1:]
                if subWord not in wordDict:
                    wordDict[subWord] = [word]
                else:
                    wordDict[subWord].append(word)

        queue = [(beginWord, 1)]
        visited = set()
        visited.add(beginWord)

        while len(queue) != 0:
            pair = queue[0]

            queue = queue[1:]

            word = pair[0]
            level = pair[1]

            for i in range(0, length):
                subWord = word[0:i] + '*' + word[i + 1:]

                if subWord in wordDict:
                    allPossibleWords = wordDict[subWord]

                    for possibleWord in allPossibleWords:
                        if possibleWord == endWord:
                            return level + 1

                        if possibleWord not in visited:
                            visited.add(possibleWord)
                            queue.append((possibleWord, level + 1))
                else:
                    wordDict[subWord] = []

        return 0