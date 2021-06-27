// Time Complexity :O(m^2*n) where n in the number of words and m is the length of the word
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& dict) {
        if(find(dict.begin(),dict.end(),endWord)==dict.end())
            return 0;
        queue<string> q;
        set<string> hSet;
        for(auto c : dict){
            hSet.insert(c);
        }
        q.push(beginWord);
        int count = 0;
        string curr;
    while(!q.empty()){
        count++;
        int size = q.size();
        for(int i = 0; i < size;i++){
            curr = q.front();
            q.pop();
            for(int s = 0;s < curr.length();s++){
                string temp = curr;
                for(char c = 'a';c <='z';c++){
                temp[s] = c;
                    if(curr == temp) continue;
                    if(temp == endWord) return count+1;
                    if(hSet.find(temp) != hSet.end()){
                        q.push(temp);
                        hSet.erase(temp);    
                    }
                }    
            }
        }
    }
    return 0;
    }
};