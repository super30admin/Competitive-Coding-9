# Problem 2 : Word Ladder
# Time Complexity : O(N * L) where N is the number of words in the word list and L is the length of a word
# Space Complexity : O(N * L) where N is the number of words in the word list and L is the length of a word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import defaultdict, deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # check if the endWord is not in the word list
        if endWord not in wordList:
            # if the word is not in the list then return 0
            return 0
        
        # define a dictionary where key is pattern and the value is list of the word for that pattern
        neighbourWord = defaultdict(list)
        # append the beginWord to wordList
        wordList.append(beginWord)
        # each word in wordList find the pattern and add to the dictionary
        for word in wordList:
            # for loop for each character in a word
            for j in range(len(word)):
                # create a pattern by replacing the single character with *
                pattern = word[:j] + "*" + word[j+1:]
                # add the word as value for the pattern key in the dictionary
                neighbourWord[pattern].append(word)

        # define the set of visited word and add beginWord to the set
        visitedWord = set([beginWord])
        # define a queue and add beginWord to the queue
        q = deque([beginWord])
        # define the result variable to store the number of words in the transformation sequence
        result = 1
        # loop till the queue is not empty
        while q:
            # traverse through the level wise ie bfs order to get the shortest the transformation sequence
            for i in range(len(q)):
                # pop the first word in the queue
                word = q.popleft()
                # check if the word is the endWord
                if word == endWord:
                    # if it is then return the value of result
                    return result
                # loop through each character of the popped word
                for j in range(len(word)):
                    # create pattern for that character place in word
                    pattern = word[:j] + "*" + word[j+1:]
                    # find all the word from the dictionary that match the pattern
                    for neighbouringWord in neighbourWord[pattern]:
                        # check if the word is not in visitedWord
                        if neighbouringWord not in visitedWord:
                            # if it is not then add in the visitedWord set
                            visitedWord.add(neighbouringWord)
                            # add the word in the queue
                            q.append(neighbouringWord)
            # increment the result value
            result += 1
        # if endWord not found then return 0
        return 0
        