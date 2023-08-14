#Time complexity is: O(N*length) where N is the no of words in wordList and length is the length of each word
#Space complexity is: O(N*length)
#No issues faced while coding
#Code ran successfully on leetcode

from collections import deque

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        #base condition
        if endWord not in wordList:
            return 0

        # Preprocess the word list to create a mapping of possible transformations
        #initializing all the required variables
        dictionary = {}
        length = len(beginWord)
        #We will be going through each word in the wordList
        for w in wordList:
            for j in range(length):
                #We will make possible combinations
                word = w[:j] + '*' + w[j + 1:]
                #We will search for that combination in the dictionary 
                lst = dictionary.get(word, [])
                #We will append that to the list and we will update the value for that particular word in the dictionary
                lst.append(w)
                dictionary[word] = lst

        #Creating a queue
        q = deque()
        #We are going to solve the problem in a BFS way
        # Store the word and its corresponding level
        q.append((beginWord, 1))  
        #Creating a hashset for visited array
        visited = set()
        #We are adding the begining word
        visited.add(beginWord)

        while len(q):
            #we are retriving the word and the level from the queue
            word, level = q.popleft()
            for i in range(length):
                #We will form the new word from the word
                newWord = word[:i] + '*' + word[i + 1:]
                #We will returve adjacent words form the dictionary for that particular word
                for adjword in dictionary.get(newWord, []):
                    #If the adjacent word is equal to endword, then we will return level+1
                    if adjword == endWord:
                        return level + 1
                    #If adjacent word not in visited array, we will add that to the visited array and the queue
                    if adjword not in visited:
                        visited.add(adjword)
                        q.append((adjword, level + 1))

        return 0
