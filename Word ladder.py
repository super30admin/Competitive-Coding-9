from collections import defaultdict


class Solution:
    def ladderLength(self, beginWord, endWord, wordList) :

        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        hmap = defaultdict(list)
        length = len(beginWord)

        for w in wordList:
            for i in range(length):
                word = w[0:i] + "-" + w[i + 1:length]
                hmap[word].append(w)

        q = ([(beginWord, 1)])
        existing = set()
        existing.add(beginWord)

        while q:

            word, level = q.pop(0)

            for i in range(length):
                key = word[0:i] + "-" + word[i + 1:length]
                for w in hmap[key]:

                    if w == endWord:
                        return level + 1

                    if w not in existing:
                        existing.add(w)
                        q.append((w, level + 1))
        return 0