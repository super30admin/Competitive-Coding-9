# Time complexity : O(k^2*n) k --> lenght of word, n - words in dict
# Space complexity : O(n)
# Leetcode : Solved and submitted

from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # check for cases if both the words are not given or the len is not same or endWord is not in the dict
        if not beginWord or not endWord or not wordList or len(beginWord) != len(endWord):
            return 0
        
        # we use queue to keep track of the levels and the words that we come across
        q = deque([beginWord])
        n = len(beginWord)
        
        # maintain a set of wordList to keep track of the words encountered
        seen = set(wordList)
        level = 1
        
        # traverse until the queue is empty
        while q:
          # fetch the size of the queue
            size = len(q)
            for i in range(size):
              # pop the first element from the queue
                currWord = q.popleft()
                
                # iterate over the word
                for i in range(len(currWord)):
                  # we will be finding out all the combinations of the word that we have
                    for j in range(26):
                        # finding the newCharacter by changing the char
                        newChar = chr(ord('a') + j)
                        # create a substring with the new char
                        substr = currWord[:i] + chr(ord('a') + j) + currWord[i+1:]
                        
                        # check if the word is present in the set and also we do not want to go over the same word again, 
                        # so we check if the new char is not the same as the old char
                        if substr in seen and newChar != currWord[i]:
                            # if we have not visited the word yet, then add it to the queue and remove it from the set
                            q.append(substr)
                            seen.remove(substr)
                            # if the substr we have right now is the same as endWord, then we return curr level + 1
                            if substr == endWord:
                                return level + 1
            # increase the level as we do in BFS as we are looking for the shortest path
            level += 1
        return 0
