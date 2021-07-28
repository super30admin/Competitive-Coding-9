// Time Complexity :O(m^2*n) where n = number of words and m = length of the word
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Word Ladder

#include<iostream>
#include<vector>
#include<string>
#include<unordered_set>
#include<queue>
using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        // put the words in a set
        
        unordered_set<string> s1;
        
        for(int i = 0; i < wordList.size(); i++)
            s1.insert(wordList[i]);
        
        if(s1.find(endWord) == s1.end())
            return 0;
        
        queue<string> q1;
        int count = 0;
        
        q1.push(beginWord);
        
        while(!q1.empty()){
            
            count++;
            int size = q1.size();
            while(size > 0){
                string curr = q1.front();
                q1.pop();
                
                for(int j = 0; j < curr.size(); j++){
                    string temp = curr;
                    for(char c = 'a'; c <= 'z'; c++){
                        temp[j] = c;
                        if(temp == curr)
                            continue;
                        if(temp == endWord)
                            return count + 1;
                        if(s1.find(temp) != s1.end()){
                            q1.push(temp);
                            s1.erase(temp);
                        }
                    }
                }
                
                size--;
            }
        }
        
        return 0;
    }
};