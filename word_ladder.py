# Brute Force Approach

def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

    if not beginWord or beginWord not in wordList or not endWord or endWord not in wordList:
        return 0


    word_set = set(wordList)
    queue = collections.deque()
    queue.append((beginWord, 1))

    while queue:

        current_word, distance =  queue.popleft()
        
        if current_word == endWord:
            return distance

        for i in range(len(current_word)):
            for c in "abcdefghijklmnopqrstuvwxyz":
                newWord = current_word[0:i] + c + current_word[i+1 : len(current_word)]

                if newWord in word_set:
                    word_set.remove(newWord)
                    queue.append((newWord, distance + 1))
    return 0


# Optimized approach
# Time - O(M ^ 2 N)
# Space - O(M ^ 2 N)

def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

    if not beginWord or beginWord not in wordList or not endWord or endWord not in wordList:
        return 0

    adj_list = defaultdict(list)
    for word in wordList:

        for i in range(len(word)):

            newWord = word[0:i] + "*" + word[i+1 :len(word)]

            if newWord not in adj_list:
                adj_list[newWord] = []

            adj_list[newWord].append(word)

    q = collections.deque()
    q.append((beginWord, 1)) # starting word & level

    visted_arr = set()
    visited.add(beginWord)

    while q:

        current_word, dist = q.popleft()

        for i in range(len(current_word)):
            newWord = current_word[0:i] + "*" + current_word[i+1:len(current_word)]

            if newWord in adj_list and adj_list[newWord] != []: # we have neighbors to process

                for neighbor in adj_list[newWord]:
                    if neighbor == endWord:
                        return dist + 1

                    if neighbor not in visted_arr:
                        visited_arr.add(neighbor)
                        q.append((visited_arr, dist + 1))

    return 0


