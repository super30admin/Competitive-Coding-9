#time: O(nm^2)where n is the total no of words and m is the length of each word
#space: O(n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset=set(wordList)
        if endWord not in wordset or wordList==[]:
            return 0
        length=1
        q=deque()
        q.append(beginWord)
        while(q!=deque()):
            size=len(q)
            for i in range(size):
                word=q.popleft()
                chararray=list(word)
                for i in range(len(chararray)):
                    tmp=chararray[i]
                    j='a'
                    while(j<='z'):
                        if (j!=chararray[i]):
                            chararray[i]=j
                            string="".join(chararray)
                            if(string==endWord):
                                return length+1
                            if(string in wordset):
                                q.append(string)
                                wordset.remove(string)
                            
                        j=chr(ord(j)+1)
                    chararray[i]=tmp
            length+=1
            
        return 0
            
                        
                        
        
        
        