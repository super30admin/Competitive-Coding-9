//my tried dfs sol - TLE after 23 tests - O(n^n)
/*
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        vector<bool> visited(n, false);
        unordered_map<string, int> umap;
        for(int i = 0; i < n; i++) {
            umap[wordList[i]] = i;
        }
        int result = 0;
        int count = 0;
        dfs(beginWord, endWord, umap, result, count, visited);
        if(result == 0) return 0;
        return result+1;
    }
private:
    void dfs(string beginWord, string endWord, unordered_map<string, int> &umap, int &result, int &count, vector<bool> &visited) {
        //base
        if(beginWord == endWord) {
            if(result == 0) result = count;
            else result = min(result, count);
            //cout<<result<<endl;;
            return;
        }
        //logic
        int n = beginWord.length(); // hit
        for(int i = 0; i < n; i++) {
            string curr = "";
            for(char a = 'a'; a <= 'z'; a++) {
                curr = beginWord.substr(0, i) + a + beginWord.substr(i+1, n-i-1);
                if(umap.find(curr) != umap.end() && visited[umap[curr]] == false && curr != beginWord) {
                    //cout<<curr<<endl;
                    visited[umap[curr]] = true;
                    count++;
                    dfs(curr, endWord, umap, result, count, visited);
                    count--;
                    visited[umap[curr]] = false;
                }
            }
        }
    }
};
*/

//good explanation - https://leetcode.com/problems/word-ladder/solutions/1764371/a-very-highly-detailed-explanation/
//https://leetcode.com/problems/word-ladder/solutions/40707/c-bfs/
//time: O(M^2 * N), where M is size of dequeued word & N is size of our word list
//space: O(M * N) where M is no. of character that we had in our string & N is the size of our wordList
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        queue<string> todo;
        todo.push(beginWord);
        int ladder = 1;
        while (!todo.empty()) {
            int n = todo.size();
            for (int i = 0; i < n; i++) {
                string word = todo.front();
                todo.pop();
                if (word == endWord) {
                    return ladder;
                }
                dict.erase(word);
                for (int j = 0; j < word.size(); j++) {
                    char c = word[j];
                    for (int k = 0; k < 26; k++) {
                        word[j] = 'a' + k;
                        if (dict.find(word) != dict.end()) {
                            todo.push(word);
                        }
                    }
                    word[j] = c;
                }
            }
            ladder++;
        }
        return 0;
    }
};