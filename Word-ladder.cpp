/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: BFS - Push the begin word in the queue, for each word in queue check if replacing any
one char will lead to the word in the wordList. If yes, add that word to the queue and check 
the same for that word as well. Also, use a set for searching the word and erase it from set
once its added to queue.

Prob: 127. Word Ladder
*/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        queue<string> q;
        unordered_set<string> s(wordList.begin(),wordList.end());
        q.push(beginWord);
        int l = 1;
        while(!q.empty()){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                auto word = q.front();
                q.pop();
                if(word == endWord) return l;
                s.erase(word);
                for(int j=0;j<word.length();j++){
                    char c = word[j];
                    for(int k=0;k<26;k++){
                        word[j] = 'a' + k;
                        if(s.find(word) != s.end()){
                            q.push(word);
                        }
                    }
                    word[j] = c;
                }
            }
            l++;
        }
        return 0;
    }
};