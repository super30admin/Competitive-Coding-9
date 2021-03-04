class Solution:
    
    """
    Description: Give size of word ladder from a list of words and target with shortest transformation sequence with difference of only 1 word
    
    Time Complexity: O(n^2*k), where n -> size of wordList and k -> average number of letters in words
    Space Comlexity: O(n)
    
    Approach: Using BFS
    1. use a set and queue with begining word
    2. find words with difference of 1 in the given list for each items popping from the queue
    3. for each level of processed queue, add 1 to the shortest path 
    4. return path only if the word is found after traversal otherwise return 0
    """
    
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if wordList == None or len(wordList) == 0: return 0
        
        from collections import deque
        queue = deque(); wordSet = set()
        queue.append((beginWord, 1))
        wordSet.add(beginWord)
        level = 0
        
        while queue:
            w, level = queue.popleft()
            for word in wordList:        
                if w == endWord: return level
                if self.ifDifferent(w, word) and word not in wordSet:
                    queue.append((word, level + 1))
                    wordSet.add(word)

        return 0
        
    def ifDifferent(self, word1, word2):

        diff_count = 0
        for c1, c2 in zip(word1, word2):
            if c1 != c2: diff_count += 1

        return True if diff_count == 1 else False
