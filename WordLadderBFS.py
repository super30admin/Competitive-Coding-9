class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wl = set(wordList)
        if(not endWord in wl):
            return 0
        
        def diff(w1,w2):
            flag = False
            i = 0
            while(i<len(w1)):
                if(w1[i]!=w2[i]):
                    if(flag==False):
                        flag = True
                    else:
                        return False
                i+=1
            return True
        
        
        q = deque([beginWord])
        k=1
        while(len(q)>0):
            size=len(q)
            k+=1
            for i in range(0,size):
                e = q.pop()
                o = set()
                for i in wl:
                    if(diff(e,i)):
                        o.add(i)
                        if(i==endWord):
                            return k
                for i in o:
                    wl.remove(i)
                    q.appendleft(i)
        
        return 0  
