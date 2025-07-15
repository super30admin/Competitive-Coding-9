# Time complexity: O(N * M * 26)
# Space complexity: O(N)

from collections import deque
from typing import List

class Solution:
    def ladderLength(self, start_word: str, target_word: str, dictionary: List[str]) -> int:
        word_bank = set(dictionary)
        if target_word not in word_bank:
            return 0
        
        frontier = deque([(start_word, 1)])
        explored = set([start_word])
        
        while frontier:
            current_word, step_count = frontier.popleft()
            if current_word == target_word:
                return step_count
            
            for i in range(len(current_word)):
                for char in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = current_word[:i] + char + current_word[i+1:]
                    if next_word in word_bank and next_word not in explored:
                        explored.add(next_word)
                        frontier.append((next_word, step_count + 1))
        
        return 0
