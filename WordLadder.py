class Solution:
    '''
    Time Complexity - O(MN)
    Space Complexity - O(M)
    Code accepted on leetcode
    '''
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        #base case
        if not beginWord or not endWord or len(wordList)==0 or beginWord == endWord or endWord not in wordList:
            return 0    
        
        n = len(beginWord) #maximum relation 
        bucket=dict() # For storing the list of words which can for that particular transformed word
        
        # Loop for getting all the related words basically we are creating the graph and getting the connected nodes
        for word in wordList:
            for i in range(n):  # for generating all possible combinations like for hot- *ot,h*t,ho*
                transformed_word = word[:i]+'*'+word[i+1:] #tranformed word = *ot for hot 
                # if transformed word in bucket, then append the word to the existing list present at bucket[transformed_word] 
                if transformed_word in bucket: 
                    bucket[transformed_word].append(word)
                else: #else create a new key in bucket and store the word in the list  
                    bucket[transformed_word] = [word]
              
        visited = set() # creating a visited set so that we do not append the same word twice in the array
        level=1 #
        queue = deque([(beginWord, 1)]) #queue storing word and level
        visited.add(beginWord)
        
        #bfs
        while queue:
            curr,level=queue.popleft()
            for i in range(n): 
                intermediate_word = curr[:i]+'*'+curr[i+1:]
                if intermediate_word in bucket:
                    for word in bucket[intermediate_word]:
                        if word == endWord:
                            return level+1
                        if word not in visited:
                            visited.add(word)
                            queue.append((word,level+1))
        return 0