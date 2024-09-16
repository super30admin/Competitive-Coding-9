#TC: O(len(wordlist)*len(word)^2) - we can ignore bfs TC since it would be much smaller than preparin adjacency matrix
#SC : O(len(wordlist)) - for adjacency matrix
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        m = len(wordList[0])
        #remove duplicates
        wordList = set(wordList)
        
        #add the begin word in the wordlist set to create graph
        wordList.add(beginWord)
        
        #create adjacency matrix
        matrix = collections.defaultdict(list)
        for word in wordList:
            for i in range(m):
                s = word[:i] + '_' + word[i+1:]
                matrix[s].append(word)
            
        # do bfs to find the minimum distance between the begin word to end word in the graph
        queue = [beginWord]
        mark = set()
        mark.add(beginWord)
        dist = 1
        while queue:
            next_queue = []
            while queue:
                word = queue.pop(0)
                for i in range(m):
                    s = word[:i] + '_' + word[i+1:]
                    for next_word in matrix[s]:
                        if next_word not in mark:
                            if next_word == endWord:
                                return dist + 1
                            mark.add(next_word)
                            next_queue.append(next_word)
            queue = next_queue
            dist += 1
        #when there is no path
        return 0