#Time Complexity O(M^2N), M length of words, N number of words
#Space Complexity O(M^2N)

'''
We keep a hashmap of all posible words template (1ab) as keys and a hashset
with all the valid words we can transform the template to. For example
1ab can become aab,bab,cab. The word is only valid if it's in the wordlist.
Thus for each word in the word list, we create all the possible templates
and add them to the hashmap, and add the word itself to the value of these keys.
Then, from beginWord, we perform BFS by checking what template the word can become
and where we can go from these templates. We keep track of the generations (level order)
to know what is the length of the branches. When we encounter a template that
can be changed to endWord, we return the length of the path.
'''

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        change_to={}
        for word in wordList:
            for i in range(len(word)):
                template=(word[:i]+"1"+word[i+1:])
                if template not in change_to:
                    change_to[template]=set()
                change_to[template].add(word)
                
        
        visited=set()
        q=collections.deque()
        q.append(beginWord)
        generation=1
        while q:
            size,n=len(q),0
            while q and n<size:
                n+=1
                node=q.popleft()
                for i in range(len(node)):
                    word_template=node[:i]+"1"+node[i+1:]
                    if word_template in change_to:
                        if endWord in change_to[word_template]:
                            print(word_template)
                            return generation+1
                        for word in change_to[word_template]:
                            if word not in visited:
                                q.append(word)
                                visited.add(word)
            generation+=1
            
        return 0
