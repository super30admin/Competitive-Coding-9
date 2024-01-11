class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string,int> map;
        unordered_set<string> set(wordList.begin(),wordList.end());

        int count = 1;
        queue<string> q;
        q.push(beginWord);

        while(!q.empty())
        {
            int qSize = q.size();
            while(qSize)
            {
                string s = q.front();
                q.pop();
                if(s == endWord)
                {
                    return count;
                }
                for(int i= 0; i<s.length();i++)
                {
                    char tempChar = s[i];
                    for(int j = 0;j<26;j++)
                    {
                        s[i] = j + 'a';
                        if(!map[s] && set.find(s) != set.end())
                        {
                            q.push(s);
                            map[s] = 1;
                        }
                    }
                    s[i] = tempChar;
                }
                qSize--;
            }
            count++;
        }

        return 0;

    }
};