    """
    Approach: if a word has length L there are L options to derieve patterns that is at each index put a *
    and see if others words follow that pattern if they do add in the hashmap and create a adjacency list
    start from begin word and traverse through this list at each level once the word is visited add in a hashset
    to avoid redundant checks
    if we found the endWord return the level value
    Approach: Time: O(n*L*L) where n = length of word lists and L is the length of the word
    Space: O(n*L) space for adjacency list
    """
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        wordList.append(beginWord)
        adj_list = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                str_ = word[:i] + "*" + word[i+1:]
                adj_list[str_].append(word)
        visited = set()
        q = deque([(beginWord, 1)])
        while q:
            word, level = q.popleft()
            if word == endWord:
                return level
            visited.add(word)
            for i in range(len(word)):
                str_ = word[:i] + "*" + word[i+1:]
                for ngh in adj_list[str_]:
                    if ngh not in visited:
                        q.append((ngh, level+1))
        return 0

def main():
    sol = Solution()
    test_cases = [
        ("hit", "cog", ["hot","dot","dog","lot","log","cog"], 5),
        ("hit", "cog", ["hot","dot","dog","lot","log"], 0),
        ("a", "c", ["a", "b", "c"], 2),
    ]

    for i, (beginWord, endWord, wordList, expected) in enumerate(test_cases, 1):
        result = sol.ladderLength(beginWord, endWord, wordList)
        print(f"Test Case {i}: Begin = '{beginWord}', End = '{endWord}'")
        print(f"Expected: {expected}, Got: {result} → {'PASS' if result == expected else 'FAIL'}\n")

if __name__ == "__main__":
    main()
