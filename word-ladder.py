# tc O(words*wl*wl + words*wl), sc O(words*wl).
pattern_word_mapp = defaultdict(list)

for word in wordList:
    for idx in range(len(word)):
        pattern = word[:idx] + "*" + word[idx+1:]
        pattern_word_mapp[pattern].append(word)

from collections import deque
queue = deque([beginWord])
res = 0
visited = set([beginWord])

while queue:
    for _ in range(len(queue)):
        word = queue.popleft()
        if word == endWord:
            return res + 1
        
        for idx in range(len(word)):
            pattern = word[:idx] + "*" + word[idx+1:]
            for neighbor in pattern_word_mapp[pattern]:
                if neighbor not in visited:
                    queue.append(neighbor)
                    visited.add(neighbor)
    res += 1

return 0