class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wl = set(wordList)
        if(not endWord in wl):
            return 0
        # DFS backtracking- TLE
        # The reason for TLE is DFS finds all the paths and we find minimum among it. Thus causing TLE.
        # To find the shortest path, BFS or level order traversal seems a good approach
        
        # Time Complexity: Exponential
        @cache
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
        
        min1 = float("inf")
        def helper(w,wl,c):
            o = set()
            for i in wl:
                if(diff(w,i)==True):
                    if(i==endWord):
                        nonlocal min1
                        if(c+1<min1):
                            min1=c+1
                            return
                    o.add(i)
            for i in o:
                wl.remove(i)
                helper(i,wl,c+1)
                wl.add(i)
            
        helper(beginWord, wl, 1)
        if(min1==float("inf")):
            return 0
        return min1
