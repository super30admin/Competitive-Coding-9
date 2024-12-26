
        # Finds the length of the shortest transformation sequence from beginWord to endWord, 
        # given a dictionary of words.

        # Returns:
        # The length of the shortest transformation sequence, or 0 if no such sequence exists.

        # Time Complexity: O(|V| + |E|), where |V| is the number of vertices (words) 
        # and |E| is the number of edges (connections between words).
        # In the worst case, all words in the wordList might be connected.

        # Space Complexity: O(|V| + |E|), where |V| is the number of vertices (words) 
        # and |E| is the number of edges (connections between words). 
        # Space is used to store the queue, explored set, and potentially the word set.


from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list) -> int:
        # Set to store all words in the word list for O(1) lookup
        word = set(wordList)
        
        if endWord not in word:
            return 0
        
        # Queue for BFS implementation
        word_que = deque([beginWord])
        # Set to keep track of the words that have already been explored
        explored = set([beginWord])
        # Counter to keep track of the number of transformations
        counter = 1

        while word_que:
            # Number of elements at the current level of BFS
            for _ in range(len(word_que)):
                curWord = word_que.popleft()

                # If the word is equal to endWord we have the answer, we return the counter
                if curWord == endWord:
                    return counter

                # Loop through each character in the current word
                for i in range(len(curWord)):
                    # Loop through the alphabet to generate new words
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        # Generate new word by replacing the character at position i with j
                        newWord = curWord[:i] + j + curWord[i+1:]

                        # Check if the new word is in the word set and hasn't been explored
                        if newWord in word and newWord not in explored:
                            word_que.append(newWord)
                            explored.add(newWord)
            
            # Incrementing counter to get the number of transformations
            counter += 1

        return 0