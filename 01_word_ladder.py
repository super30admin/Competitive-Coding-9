# Time Complexity : O(nxm^2) where n is the number of words in the list and m in the length of the word 
'''
Adjacency List Time Complexity : O(nxm^2)
for creating the adjacency list we iterate over each word m times and forming the word takes O(m) time so total time complexity is O(n*m^2)

BFS tim complexity: (nxm^2)
to perform BFS also we need O(nxm^2), since in worst case we will visit all n nodes. For each word we will travese m times to  get intermediatory results.

Total Time Complexity: (nxm^2)
'''
# Space Complexity :  O(nxm^2)
'''
Adjacency List Space Complexity : O(nxm^2)
For each word we create m patterns and store the original word of length m so for every word we need space of m^2

Visited Space Complexity: O(mxn)
since we will store all n words of size m

so total space complexity: O(nxm^2)

'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : it was difficult to understand how to build the adjacency list

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if endWord not in wordList:
            return 0
        
        hashMap = collections.defaultdict(list)
        wordList.append(beginWord)
        
        #building the adjacency list
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] +"*"+ word[j+1:] #skip the jth character to get the pattern
                hashMap[pattern].append(word)
        
        visited = set([beginWord])
        q = collections.deque()
        q.append(beginWord)
        count = 1

        #using BFS to find the shortest path
        while(len(q) != 0):
            size = len(q)
            while(size > 0):
                word = q.popleft()
                if word == endWord:
                    return count
                for j in range(len(word)):
                    pattern = word[:j] +"*"+ word[j+1:]
                    for neighbour in hashMap[pattern]:
                        if neighbour not in visited:
                            q.append(neighbour)
                            visited.add(neighbour)
                size -= 1
            count += 1
        return 0