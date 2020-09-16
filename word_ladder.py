class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        dict1=defaultdict(list)
        if endWord not in wordList or not beginWord or not endWord or not wordList:
            return 0
        N=len(beginWord)
        for word in wordList:
            for i in range(N):
                key=word[:i]+"*"+word[i+1:]
                dict1[key].append(word)
        visited={beginWord:True}
        Queue=deque([(beginWord,1)])
        while Queue:
            word1,count=Queue.popleft()
            for i in range(N):
                temp_key=word1[:i]+"*"+word1[i+1:]
                for word in dict1[temp_key]:
                    if word==endWord:
                        return count+1
                    if word not in visited:
                        Queue.append((word,count+1))
                        visited[word]=True
            dict1[temp_key]=[]
        return 0
#Time-complexity: O(M^2 * N)
#Space-complexity: O(M^2 * N)