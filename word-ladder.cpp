//Time - O(n*len(wordList))
//Space - O(n)

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> wordSet (wordList.begin(),wordList.end());
        unordered_set<string> seen;
        
        seen.insert(beginWord);
        int level = 0;
        queue<string> q;
        q.push(beginWord);

        while(!q.empty()){
            level++;
            int size = q.size();
            while(size-->0){
                string str = q.front();q.pop();
                if(str == endWord) return level;
                for(int i = 0;i<str.size();i++){
                    string newStr = str;
                    for(char c = 'a';c<='z';c++){
                        newStr.replace(i,1,1,c);
                        if(wordSet.find(newStr)!=wordSet.end() && seen.find(newStr)==seen.end()){
                            q.push(newStr);
                            seen.insert(newStr);
                        }
                        
                    }
                }
            }
        }
        
        return 0;
    }
};