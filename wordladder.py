class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        #TC-O(NM*2),SC-O(NM*2) M is the len of word
        if(beginWord==endWord or beginWord=='' or endWord==''):
            return 0;
        queue = []
        queue.append(beginWord)
        s = set(wordList)
        level=0
        def comb(word):
            ll = []
            for c in range(len(word)):
                print(c)
                for i in range(97,123):
                    newword = word[0:c] + chr(i) + word[c+1:] 
                    ll.append(newword)
            return ll
        while(len(queue)>0):
            l = len(queue)
            level+=1
            for i in range(l):
                word = queue.pop(0)
                if(word==endWord):
                    return level
                combinations = comb(word)
                for w in combinations:
                    if w in s:
                        queue.append(w)
                        s.remove(w)

        return 0
