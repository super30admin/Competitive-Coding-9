#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We search from both beginWord and endWord using two sets and always expand the smaller set first to stay efficient.
At each step, we transform characters to generate all possible next words and check for connection between the two ends.
If both searches meet, we return the path length; otherwise, we continue — and since we search from both sides, this bidirectional strategy is optimal and much faster than one-way BFS.
*/
class Solution{
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){
        if(beginWord == endWord) return 0;

        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if(!wordSet.count(endWord)) return 0;

        unordered_set<string> beginSet, endSet, visited;
        beginSet.insert(beginWord);
        endSet.insert(endWord);
        visited.insert(beginWord);
        visited.insert(endWord);
        int level = 1;

        while(!beginSet.empty() && !endSet.empty()){
            if(beginSet.size() > endSet.size()) swap(beginSet, endSet);

            unordered_set<string> tempSet;
            for(const string& word : beginSet){
                string cArr = word;
                for(int i = 0; i < cArr.size(); i++){
                    char originalChar = cArr[i];
                    for(int c = 'a'; c <= 'z'; c++){
                        cArr[i] = c;
                        if(endSet.count(cArr)) return level + 1;

                        if(wordSet.count(cArr) && !visited.count(cArr)){
                            tempSet.insert(cArr);
                            visited.insert(cArr);
                        }
                    }
                    cArr[i] = originalChar;
                }
            }
            beginSet = tempSet;
            level++;
        }
        return 0;
    }
};
