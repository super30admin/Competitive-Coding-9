"""
Runtime Complexity:
O(n^2 *m) - where 'n' is the number of words present in the list and 'm' is the length of each word. Here we perform a BFS approach by going through each 
word in the list and change every letter(pattern) and store that as key and the values as the words which match the same pattern. We initialise a queue and perform a BFS and get the 
shortest path from begin to the endword.
Space Complexity:
O(n^2*m) -  we store each pattern with their responding words of size m.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        neighbours = collections.defaultdict(list)
        wordList.append(beginWord)
        for word in wordList:
            for j in range(len(word)):
                pattern =  word[:j] +"*" + word[j+1:]
                neighbours[pattern].append(word)
        visit = set([beginWord])
        q = deque([beginWord])
        result = 1
        while q:
            for i in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return result
                for j in range(len(word)):
                    pattern =  word[:j] +"*" + word[j+1:]
                    for words in neighbours[pattern]:
                        if words not in visit:
                            visit.add(words)
                            q.append(words)
            result+=1
        return 0
                    
        