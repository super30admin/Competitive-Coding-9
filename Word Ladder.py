'''
Solution: BFS. 
- Given question is like a tree and we need to find shortest distance between 2 nodes 
  (start and end word) in tree. 
- The babies of nodes are determined by words in list matching 1 char change in 
  currrent word.
  eg. hit -> *it, h*t, hi*. All the words which match this pattern are babies of hit. 
Time Complexity: N = total words, L = length of word
    - O(N*L) - forming patterMap dictionary
    - O(N*L) - Visit every pattern
Space Complexity: 
    - O(N*L)
'''

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        size=len(beginWord) #given all words in the wordlist and start and end words are of same ladderLength
        patternMap=dict() #mapping of pattern to corresponding words 

        for word in wordList:
            for i in range(size):
                pattern =  word[:i] + '*' + word[i+1:]
                if pattern not in patternMap:
                    patternMap[pattern] = []
                patternMap[pattern].append(word)

        myQ=deque() #BFS
        visited=set()

        myQ.append([beginWord,1]) #start from begin word, mark it visited. total length traversed =1
        visited.add(beginWord)

        while len(myQ)!=0:
            curr=myQ.popleft()
            curr_word=curr[0]
            for i in range(size):
                pattern =  curr_word[:i] + '*' + curr_word[i+1:]
                if pattern in patternMap:
                    #visit all the babies if not visited and mark it visited. Also check if the baby is our endword then return
                    for baby in patternMap[pattern]:
                        if baby==endWord:
                            return curr[1]+1
                        if baby not in visited:
                            myQ.append([baby,curr[1]+1]) 
                            visited.add(baby)
        
        #if they are not connected
        return 0