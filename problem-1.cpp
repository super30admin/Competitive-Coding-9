// https://leetcode.com/problems/word-ladder/description/
// Time Complexity : O(nm) where n is the length of the word and m is the legnth of the wordList
// Space Complexity : O(m)


class Solution {
    public:
        int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
            unordered_set<string> mp(wordList.begin(),wordList.end());
            if(mp.find(endWord) == mp.end()) return 0;
            queue<string> q;
            q.push(beginWord);
            mp.erase(beginWord);
            int cnt=1;
            while(!q.empty()){
                int n = q.size();
                for(int i=0; i<n; i++){
                    string temp = q.front(); q.pop();
                    if(temp == endWord) return cnt;
                    for(int k=0; k<temp.size(); k++){
                        char ch = temp[k];
                        for(int j=0; j<26; j++){
                            temp[k] = 'a' + j;
                            if(mp.find(temp) != mp.end()){
                                q.push(temp);
                                mp.erase(temp);
                            } 
                        }
                        temp[k] = ch;
                    }
                    
                }
                cnt++;
            }
            return 0;
    
        }
    };