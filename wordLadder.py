class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        length = 1
        wordList = set(wordList)
        front, back = set([beginWord]), set([endWord])
        while front:
            print(front, back)
            if front & back:
                return length
            length += 1
            wordList -= front
            front = self.distance_be_1(front, wordList, beginWord)
            if len(front) > len(back):
                front, back = back, front
        return 0
    
    def distance_be_1(self, front, wordList, beginWord):
        return wordList & (set(word[:index] + ch + word[index+1:] for word in front 
                            for index in range(len(beginWord)) for ch in 'abcdefghijklmnopqrstuvwxyz'))
                    
