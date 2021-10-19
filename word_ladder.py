# // Time Complexity :O(m^2n) m total words n length of each word
# // Space Complexity :O(m) m is the totale number of words
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : had to refer video multiple times for coding


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        hset={}
        q=[]
        q.append((beginWord,1))
        print(q)
        size=len(beginWord)
        if size==1:
            return len(wordList)-1
        for j in range(size):
                word=beginWord[:j]+'*'+beginWord[j+1:]
                if word not in hset.keys():
                    hset[word]=[]
                hset[word].append(beginWord)
        
        for w in wordList:
            for j in range(size):
                word=w[:j]+'*'+w[j+1:]
                if word not in hset.keys():
                    hset[word]=[]
                hset[word].append(w)
        print(hset)
        # if len(hset)==1:
            
        visited={}
        visited[beginWord]=True
        
        while q:
            temp=q.pop(0)
            w=temp[0]
            level=temp[1]
            print(level)
            print("x",w)
            for j in range(size):
                word=w[:j]+'*'+w[j+1:]
                
                li=hset[word]
                for i in li:
                    if i not in visited.keys():
                        visited[i]=True
                        
                        if i == endWord:
                            return level+1
                        print(i)
                        q.append((i,level+1))

                        
        return 0

            
            
        
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         temp=q.pop(0)
        #         l=len(temp)
                
                
            
            
        