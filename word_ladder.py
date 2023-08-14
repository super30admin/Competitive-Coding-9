# Time Complexity :
# O(M)  - Where M is the size of the wordlist 

# Space Complexity :
# O(M)

# Did this code successfully run on Leetcode :
#Yes

#Given a word, we check if any of it's single character variations exist in the word list (after creating the dictionary of it). If it is, then it is a potential next word. We find all potential next words and then repeat the same for all potential next words until one of the potential next words is the endWord itself. Each time we find the endWord, we store the amount of steps it took to reach, and compare them all and return the minimum at the end
#We see that we could return to some words by manipulating the same character again and hence keep a track of all the visited words and only count the first time it was visited as it would be the shorted path from the first occurance
#In summary, this is applying a BFS over a tree with root and beginWord, with the children being all potential one character modified words that exist in the dictionary.

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordDict = {}
        min_length = 5005
        for word in wordList:
            wordDict[word] = 0

        #potential_new_words = [(beginWord,0)]
        potential_new_words = collections.deque()
        potential_new_words.append((beginWord,0))

        while (len(potential_new_words) != 0 ):
            beginWord,curr_len = potential_new_words.popleft()
            for i,char in enumerate(beginWord):
                for j in range(0,26):
                    char_new = chr(ord('a') + j)
                    new_word = beginWord[:i] + char_new + beginWord[i+1:]
                    
                    if new_word in wordDict and wordDict[new_word] == 0 :
                        if new_word == endWord :
                            min_length = min(min_length,curr_len)

                        potential_new_words.append((new_word,curr_len+1))
                        wordDict[new_word] = 1

        if min_length == 5005 :
            return 0
        return min_length +2
