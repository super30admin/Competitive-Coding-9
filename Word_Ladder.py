#Time: O(26*n) to try all combination of words
#Space: O(n) for queue
#Idea is to keep pushing all the possible words that can be formed by changing characters
#of the given word(new word has to be part of the wordlist ) along with the step count
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        #set for performing faster search operations
        wordList_set = set(wordList)
        
        #push first word to the queue with step count=1
        queue = deque()
        queue.append((beginWord,1))

        if endWord not in wordList_set:
            return 0
        
        #set to keep track of already visited words
        seen = set()
        seen.add(beginWord)
        
        while(queue):
            word,level = queue.popleft()
            
            if word == endWord:
                return level
            
            #convert word to a list, as string is immutable
            list_val = list(word)
            for cnt in range(len(list_val)):
                
                #store the character that is being changed
                temp = list_val[cnt]
                
                #check for all the characters possible
                for letter in range(26):
                    list_val[cnt] = chr(ord("a")+letter)
                    new_word = "".join(list_val)
                    
                    #push if this new_word is part of the word list and not seen earlier
                    if  new_word in wordList_set and new_word not in seen :
                        seen.add(new_word)
                        queue.append((new_word,level+1))    
                    
                    #reset the old word
                    list_val[cnt] = temp
                    
        return 0