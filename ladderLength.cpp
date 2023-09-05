//time: O(n*m*m)
//space: O(n)

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> set(wordList.begin(), wordList.end());

    if (set.find(endWord) == set.end()) {
        return 0; 
    }

    queue<string> q;
    q.push(beginWord);
    int depth = 0;

    while (!q.empty()) {
        int size = q.size();
        depth++;

        for (int i = 0; i < size; i++) {
            string currWord = q.front();
            q.pop();

            for (int j = 0; j < currWord.length(); j++) {
                char prevChar = currWord[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == prevChar) continue;

                    currWord[j] = c;
                    if (set.find(currWord) != set.end()) {
                        if (currWord == endWord) return depth + 1;

                        q.push(currWord);
                        set.erase(currWord);
                    }
                }

                currWord[j] = prevChar;
            }
        }
    }

    return 0;
        
    }
};