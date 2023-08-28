#TC - O(n^2*m) n->len(wordlist), m len of each word.
# SC- O(m^2*n) n->len(wordlist), m len of each word.


#Here, the moment you see need to get to beginWord to endWord and each adjacent word in wordList differ by 1 letter you can tell it's a graph problem -> BFS or DFS. 

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord: #edge case
            return 0
        
        wordList.append(beginWord)
        neighbour=defaultdict(list)

        #you can go through each word and check with rest of the word with 2 for loops->n^2*m TC but here, n is way bigger than m. So, we do it based on the letters and not word. 
        for word in wordList:
            for i in range(len(word)):
                pattern=word[:i]+"**"+word[i+1:]
                neighbour[pattern].append(word)
        

        #After building the adjacency list, just use BFS to explore the graph and arrive at the endWord
        q=deque()
        q.append(beginWord)
        visited=set()
        visited.add(beginWord)
        count=1

        while q:
            size=len(q)
            for _ in range(size): #n
                curr=q.popleft()
                if curr==endWord:
                    return count
                for i in range(len(curr)): #n
                    pattern=curr[:i]+"**"+curr[i+1:] #m
                    for neigh in neighbour[pattern]:
                        if neigh not in visited:
                            visited.add(neigh)
                            q.append(neigh)
            count+=1
        return 0

                
                




        