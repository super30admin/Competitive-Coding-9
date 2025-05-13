from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        # BFS approach
        # Same as what we discussed during the interview, just using BFS instead of DFS
        # Here, instead of exploring an individual path at a time, we explore all the paths with exactly 1 mismatch character with the current level of words at the same time.
        # We also maintain the steps taken so far
        # initializing queue to keep track of levels
        q = deque()
        # visit set to keep track of words that we have already visited
        visit = set()

        # Store all the words in queue that has exactly 1 mismatch letter with the begin word
        # Whatever words we are adding in the queue, we also add them to the visit set
        for word in wordList:
            if word not in visit:
                mismatch = 0
                for i in range(len(word)):
                    if word[i] != beginWord[i]:
                        mismatch += 1
                if mismatch == 1:
                    visit.add(word)
                    q.append(word)

        # Initialize steps, to keep track of the steps taken
        steps = 1
        # While we have words in queue, we will keep looking for the endWord
        while q:
            # Increment steps, because we are exploring all the words that has 1 different character from the current level of words
            steps += 1
            # Keep popping from the queue for the current level
            for i in range(len(q)):
                currWord = q.popleft()
                # If at any point we reach the end word, we can return the steps taken so far
                if currWord == endWord:
                    return steps
                # Otherwise, we explore all the words in the word, count the difference of characters
                for word in wordList:
                    # We do not want to visit the same words we have already visited in order to maintain the minimum number of steps.
                    if word not in visit:
                        mismatch = 0
                        for i in range(len(currWord)):
                            if word[i] != currWord[i]:
                                mismatch += 1
                        # All the words with 1 character difference, we want to explore in the next step
                        if mismatch == 1:
                            # So we append them to the queue
                            q.append(word)
                            # And mark them as visited
                            visit.add(word)
        # If after exploring all the words in the wordList, we are unable to find the endWord, we return 0
        return 0


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0

        memo = {}

        def mismatch(w1, w2):
            diff = 0
            for a, b in zip(w1, w2):
                if a != b:
                    diff += 1
                    if diff > 1:
                        return False
            return diff == 1

        def dfs(currWord, visited):
            # Base case: if we reach the endWord
            if currWord == endWord:
                return 1

            # Check if the current word has been already computed in the memo
            if currWord in memo:
                return memo[currWord]

            # Initialize minimum steps to a large value
            minSteps = float('inf')

            # Explore all the possible valid neighbors
            for word in wordSet:
                if word not in visit and mismatch(currWord, word):
                    visit.add(word)
                    steps = dfs(word, visited)
                    if steps:
                        minSteps = min(minSteps, 1 + steps)
                    visit.remove(word)

            # Memoize the result before returning
            memo[currWord] = minSteps if minSteps != float('inf') else 0
            return memo[currWord]

        # Start DFS with the beginWord
        visit = set([beginWord])
        result = dfs(beginWord, visit)
        return result