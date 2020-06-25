class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        wordSet = set(wordList)

        if endWord not in wordSet:
            return 0

        l = len(beginWord)
        dictionary = defaultdict(list)
        for word in wordList:
            for i in range(l):
                dictionary[word[:i]+"*"+word[i+1:]].append(word)

        queue = deque([(beginWord,1)])
        visited = {beginWord: True}
        #print(queue)
        while queue:
            currentWord,level = queue.popleft()
            for i in range(l):
                replaceWord = currentWord[:i]+"*"+currentWord[i+1:]
                for word in dictionary[replaceWord]:
                    if word == endWord:
                        return level + 1
                    if word not in visited:
                        visited[word] = True
                        queue.append((word,level + 1 ))
        return 0

        print(dictionary)

        
