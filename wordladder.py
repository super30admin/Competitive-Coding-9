#Using all leetters to find word in dictionary that diffres by just 1 character, then once we find word in dictionary mark as visited and thne pop to move to next character.
#Time Complexity: O(len^2*n)
#Space Complexity: O(len^2*n)

def ladderLength(beginWord, endWord, wordList):
    wordList = set(wordList)
    visited = list()
    st = "qwertyuiopasdfghjklzxcvbnm"
    q = list()
    q.insert(0,(beginWord,1))
    while len(q)!=0:
        word,count= q.pop()
        if word == endWord:
            return count
        for i in range(len(word)):
            for cha in st:
                currWord = word[0:i] + cha + word[i+1:len(word)]
                if currWord in visited or currWord not in wordList:
                    continue
                q.insert(0,(currWord,count+1))
                visited.append(currWord)
    return 0
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
l = ladderLength(beginWord,endWord,wordList)
print(l)