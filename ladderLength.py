# Time Complexity: O(M^2*N) - M is length of each word and N is total number of words
# Space Complexity: O(M^2*N)

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not wordList or endWord not in wordList or not beginWord:
            return 0
        L=len(beginWord)
        word_dict=defaultdict(list)
        
        for word in wordList:
            for i in range(L):
                word_dict[word[:i]+"*"+word[i+1:]].append(word)
        print(word_dict)
        q=[]
        visited={beginWord:True}
        q.append([beginWord,1])
        
        
        while q:
            curr,level=q.pop(0)
            for i in range(L):
                internode=curr[:i]+"*"+curr[i+1:]
                for word in word_dict[internode]:
                    if word==endWord:
                        return level+1
                        
                    if word not in visited:
                        visited[word]= True
                        q.append([word,level+1])
                
                word_dict[internode]=[]
        return 0
                    
        
        