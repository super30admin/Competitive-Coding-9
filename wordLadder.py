#Time: O(V+E)
#Space: O(V*E)
#Problem ran on leetcode succesfully

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if not endWord:
            return 0 
        if len(endWord) == 0:
            return 0
        if beginWord not in wordList:
            wordList.append(beginWord)
        
        wordMap = dict()
        queue = []
        queue.append(beginWord)
        word_len = len(beginWord)
        for i in range(len(wordList)):
            word = wordList[i]
            for j in range(word_len):
                temp = word[0:j] + "*" + word[j+1: word_len]
                word_list = wordMap.get(temp, [])
                word_list.append(word)
                wordMap[temp] = word_list
        
        visited = {}
        visited[beginWord] = True
        num_words = 0
        while queue:
            num_words += 1
            for i in range(len(queue)):
                word = queue.pop(0)
                if word == endWord:
                    return num_words
                for j in range(word_len):
                    temp = word[0:j] + "*" + word[j+1: word_len]
                    for nextWord in wordMap.get(temp, []):
                        if nextWord not in visited:
                            visited[nextWord] = True
                            queue.append(nextWord)
        
        return 0
        
        