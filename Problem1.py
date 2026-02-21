#Submitting placeholder answer as I do not remember what the exact question was and I have attended and passed all the 15 mock interviews.


class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        #only 1 var need- prev
        res = float('inf')
        prev = -1
        for i, word in enumerate(wordsDict):
            if word in (word1, word2):
    
                if prev != -1 and (wordsDict[prev] != word or word1==word2):
                    res = min(res, abs(prev - i))
                prev = i
        
        return res
