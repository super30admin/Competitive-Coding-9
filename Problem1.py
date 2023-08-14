'''
Problem: Word Ladder
Time Complexity: O(m * n * n), where n wordList length and m in length of each word(Explained below)
Space Complexity: O(m * n * n), for dictionary
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
         create a dictionary of all the words that can be formed with begin word
         then applied BFS to find the transformation
         maintained a seen set so that i do not traverse same node again
         as soon as our element matches with endWord, we return 
'''

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        dicts = defaultdict(list)

        for word in wordList:    #O(m*n)
            for i in range(len(word)):
                dicts[word[:i]+'*'+word[i+1:]].append(word)
        
        queue = deque()
        seen = set()
        queue.append(beginWord)
        result = 0

        while queue:
            result+=1
            size = len(queue)
            for i in range(size):
                ele = queue.popleft()
                if ele == endWord:
                    return result
                for i in range(len(ele)): #O(m)
                    hold = ele[:i]+'*'+ele[i+1:]
                    for nei in dicts[hold]:
                        if nei not in seen:
                            queue.append(nei)
                            seen.add(nei)

        return 0
    
    # vertices -> m * n
    # edges are in dictionary -> m * n * n 
    # Complexity O(vetrices + edges)

        