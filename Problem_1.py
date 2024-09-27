"""
Problem : 1

Time Complexity : O(n^2*m) //m=length of word, n=length of wordList
Space Complexity : O(n*m^2)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Word Ladder

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        neighbors=collections.defaultdict(list)
        wordList.append(beginWord)
        # building adjacency list
        for word in wordList:
            for j in range(len(word)):
                pattern=word[:j]+"*"+word[j+1:]
                neighbors[pattern].append(word)
        visited=set()
        visited.add(beginWord)
        q=collections.deque()
        q.append(beginWord)
        result=1
        while q:
            for i in range(len(q)):
                word=q.popleft()
                if word==endWord:
                    return result
                for j in range(len(word)):
                    pattern=word[:j]+"*"+word[j+1:]
                    for neighbor in neighbors[pattern]:
                        if neighbor not in visited:
                            visited.add(neighbor)
                            q.append(neighbor)

            result+=1




        return 0