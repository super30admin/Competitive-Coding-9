"""
BFS Approach
TC - O(M^2 * N) --> where M is the length of each word and N is the total number of words in the input word list.
SC - O(M^2 * N)
"""

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not beginWord or not endWord or not wordList or len(wordList) == 0: return 0

        L = len(beginWord)

        # step 1: map neighbors of words (beginWord may not be in wordList)
        neighborList = defaultdict(list)
        for word in wordList:
            for i in range(L):
                neighborList[word[:i] + '*' + word[i + 1:]].append(word)

        # step 2: append word to q and add it in visited while trying to reach endWord
        # q = deque([[beginWord, level]])
        q = deque([[beginWord, 1]])
        visited = {beginWord: True}

        while q:
            currword, level = q.popleft()
            # traverse through currword's values in neighborList and append to q
            for i in range(L):
                # form intermediateword to traverse through the neighborList
                intermediateword = currword[:i] + "*" + currword[i + 1:]

                for word in neighborList[intermediateword]:
                    # check if word == endWord
                    if word == endWord:
                        return level + 1

                    if word not in visited:
                        visited[word] = True
                        q.append([word, level + 1])
                neighborList[intermediateword] = []

        return 0