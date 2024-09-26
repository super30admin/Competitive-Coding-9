from collections import deque

class Solution:                  
    
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if not beginWord or not endWord:
            return 0
        
        q = deque()
        s = set(wordList)
        q.append((beginWord,1))
        letters = []
        for i in range(ord('a'),ord('z')+1):
            letters.append(chr(i))        
        #print(letters)        
        while q:
            print(q)
            word,size = q.popleft()
            if word == endWord:
                return size                
            for i in range(len(word)):
                for letter in letters:
                    formed_word = word[:i] + letter + word[i+1:]
                    #print(formed_word)                        
                    if formed_word in s:
                        #print(formed_word)
                        s.remove(formed_word)
                        q.append((formed_word,size+1))                        
        return 0
                            
                        
                                            
      
                    
                
                

            
            
        
