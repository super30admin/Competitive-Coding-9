# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
"""
This code works by conducting a BFS search over the wordList, by matching the words in wordlist with all the possible words that can be formed by changing one character at a time.
"""

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        hashmap = {word:False for word in wordList}
        alphabets = 'abcdefghijklmnopqrstuvwxyz'
        answer = 0
        q = deque()
        q.append(beginWord)

        while q:
            size = len(q)
            answer += 1
            for _ in range(size):
                curr_word = q.popleft()
                possibilities = []
                for i in range(len(curr_word)):
                    for char in alphabets:
                        word = curr_word[:i] + char + curr_word[i+1:]
                        if word in hashmap:
                            if word == endWord: return answer + 1
                            if not hashmap[word]:
                                hashmap[word] = True
                                q.append(word) 

        return 0