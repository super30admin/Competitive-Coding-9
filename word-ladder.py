# Time Complexity: O(m^2 * n * 26) where m is the length of the word and n is the number of words in the word list
# Space Complexity: O(m^2 * n * 26) where m is the length of the word and n is the number of words in the word list
# Did this code successfully run on Leetcode : Yes

from collections import deque

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        setwords = set(wordList)
        if beginWord in setwords: setwords.remove(beginWord)
        q=deque([beginWord])
        l=0

        while(q):
            s=len(q)
            l+=1

            for i in range(s):
                child = q.popleft()
                if child==endWord:
                    return l
                
                for j in range(len(child)):
                    for ch in 'abcdefghijklmnopqrstuvwxyz':
                        new_child = child[:j] + ch + child[j+1:]

                        if new_child in setwords:
                            q.append(new_child)
                            setwords.remove(new_child)
        
        return 0