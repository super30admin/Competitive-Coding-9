class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # Base case: If the endWord is not in the wordList, no valid transformation is possible
        if endWord not in wordList:
            return 0
        
        # Dictionary to hold intermediate patterns and their corresponding words
        nei = collections.defaultdict(list)
        wordList.append(beginWord)  # Include the beginWord in the wordList for pattern generation
        
        # Create the pattern dictionary
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j + 1:]  # Replace one character with '*'
                nei[pattern].append(word)
        
        # BFS setup
        visit = set([beginWord])  # Visited set to avoid processing the same word
        q = deque([beginWord])  # Queue for BFS traversal
        res = 1  # Length of the transformation sequence
        
        # BFS loop
        while q:
            for i in range(len(q)):  # Process all nodes at the current level
                word = q.popleft()  # Get the current word
                
                if word == endWord:  # If the endWord is reached, return the sequence length
                    return res
                
                # Generate neighbors using patterns
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j + 1:]  # Generate a pattern
                    for neiWord in nei[pattern]:  # Iterate over all words matching the pattern
                        if neiWord not in visit:  # If the word is not visited
                            visit.add(neiWord)  # Mark it as visited
                            q.append(neiWord)  # Add it to the BFS queue
            res += 1  # Increment the level of BFS
        
        return 0  # Return 0 if no transformation sequence exists
