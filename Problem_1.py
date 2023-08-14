"""
Time Complexity : O(M^2 * N) M = length of words ; N = length of WordList
Space Complexity : O(M^2 * N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
127. Word Ladder : A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
which is 5 words long.


Your code here along with comments explaining your approach

"""

import collections
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
       
        wordList = set(wordList)
        wordList.add(beginWord)
        word_map = defaultdict(list)
        word_set = set([beginWord])
        # if the list does not have endWord anywhere then return 0
        if endWord not in wordList:
            return 0
        
        # create hashmap of words with their patterns
        for word in wordList:
            for c in range(len(word)):
                new_word = word[: c] + "#" + word[c+ 1:]
                word_map[new_word].append(word)
        
        
        q = deque()
        res = 1
        q.append(beginWord)
        
        
        while q:
            _size = len(q)
            
            for i in range(_size):
                currWord = q.popleft()
                
                if currWord == endWord:
                    return res
                for c in range(len(currWord)):
                    new_word = currWord[:c] + "#" + currWord[c + 1:]
                    for w in word_map[new_word]:
                        if w not in word_set :
                            word_set.add(w)
                            q.append(w)
                    
            res +=1
            
        return 0
                    
                
        