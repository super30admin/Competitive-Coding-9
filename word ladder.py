
# Time Complexity : O(M^2 * N) 
# where M is avg size of a word & N is size of our word list

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        q = []
        hset = set(wordList)
        if endWord not in hset: return 0
        q.append(beginWord)
        count = 0

        while len(q) > 0:
            count += 1
            qlen = len(q) 
            for i in range(qlen):
                curr = q.pop(0)
                if (curr == endWord):
                    return count
                for k in range(len(curr)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        new = curr[:k] + c + curr[k + 1:]
                        if (new in hset and endWord != curr):
                            q.append(new)
                            hset.remove(new)

        return 0 