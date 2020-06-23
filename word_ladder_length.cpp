//Understood the overall algo of the solution but didnt get certain aspects like the following-
	//1. Why we have to do dict.erase()
	//2. Why we have to maintain size of the queue
	

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string>dict(wordList.begin(),wordList.end());
        queue<string>q;
        q.push(beginWord);
        int ladder=1;
        while(!q.empty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                string word=q.front();
                q.pop();
                if(word==endWord)
                    return ladder;
                dict.erase(word);
                for(int j=0;j<word.size();j++)
                {
                    char c=word[j];
                    for(int k=0;k<26;k++)
                    {
                        word[j]='a'+k;
                        if(dict.count(word))
                            q.push(word);
                    }
                    word[j]=c;
                }
            }
            ladder++;
        }
        return 0;
    }
};