from collections import deque

def ladderLength(beginWord, endWord, wordList):
    wordSet = set(wordList)
    if endWord not in wordSet:
        return 0
    
    queue = deque([(beginWord, 1)])
    
    while queue:
        current_word, length = queue.popleft()
        
        if current_word == endWord:
            return length
        
        for i in range(len(current_word)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
                new_word = current_word[:i] + c + current_word[i+1:]
                
                if new_word in wordSet:
                    queue.append((new_word, length + 1))
                    wordSet.remove(new_word)
                    
    return 0

#time = O(M * N)
#space = O(M * N)