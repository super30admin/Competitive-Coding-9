// Time Complexity: O(n * L^2) where n is the number of words in the wordList and L is the length of each word.
// Space Complexity: O(n) for the queue and set.
// Did the code run on Leetcode: Yes

// Approach: BFS
// 1. Create a queue to perform BFS and a set to keep track of visited words.
// 2. Initialize the queue with the beginWord and mark it as visited.
// 3. For each word in the queue, generate all possible words by changing one letter at a time.
// 4. If the generated word is in the wordList and not visited, add it to the queue and mark it as visited.
// 5. If the generated word is the endWord, return the current length of the transformation.
// 6. If the queue is empty and the endWord is not found, return 0.

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> set(wordList.begin(), wordList.end());
        if(set.find(endWord) == set.end()){
            return 0;
        }
        queue<string> q;
        unordered_set<string> visited;

        q.push(beginWord);
        visited.insert(beginWord);
        int res = 1;
        string alphabets = "abcdefghijklmnopqrstuvwxyz";
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                string curr_word = q.front();
                q.pop();

                if(curr_word == endWord){
                    return res;
                }

                for(int i = 0; i < curr_word.size(); i++){
                    char original = curr_word[i];
                    for(char c : alphabets){
                        if(c == original){continue;}
                        curr_word[i] = c;
                        if(set.find(curr_word) != set.end() && visited.find(curr_word) == visited.end()){
                            q.push(curr_word);
                            visited.insert(curr_word);
                            
                        }
                    }
                    curr_word[i] = original;
                }
            }
            res++;
        }
        return 0;
    }
};