#Time Complexity:O(n)
#Space Complexity:O(n)
#Approach: add all possible combinations of the ladder into a hash map with the pattern as key and word of that pattern as its value list.
#Use a vistsed arry to keep a track of all the words already added to the ladder, use a queue to parse through the levels of the bfs.
#get the first element from queue and find its possible pattern in dict if the word already does not exist in the visited array.IF word is found
#in dict append it to queue for further processing . IF the end word is found. return the level of the bfs.
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        dict={}
        d=deque()
        d.append([beginWord,1])
        l=len(beginWord)
        for s in wordList:
            for j in range(l):
                word=s[0:j]+"*"+s[j+1:]
                if word not in dict:
                    dict[word]=[]
                dict[word].append(s)
        visited=[]
        while d:
            curr=d.popleft()
            w=curr[0]
            if w==endWord:
                return curr[1]
            if w in visited:
                continue
            visited.append(w)
            for i in range(l):
                newWord=w[:i]+"*"+w[i+1:]
                if newWord in dict:
                    for word in dict[newWord]:
                        d.append([word,curr[1]+1])
        return 0