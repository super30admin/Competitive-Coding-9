// Problem Name: Word Ladder
// Time Complexity : O(n)
// Space Complexity : O(n * k * 26 ) where k is length of word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. It's a graph based problem where we use BFS to find the shortest path to
// reach the endword
// 2. We start our BFS from beginWord and then for each letter of the word, we
// try to replace it with 26 characters, if that word exists in our wordlist, we
// push it to the queue and mark it visited or to save space we erase it from
// the set
// 3. If at any level, we find the endWord, we return the level as answer

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int ladderLength(string beginWord, string endWord, vector<string> &wordList) {
    unordered_set<string> se(begin(wordList), end(wordList));
    if (se.count(endWord) == 0)
      return 0;
    queue<pair<string, int>> q;
    q.push({beginWord, 1});
    while (!q.empty()) {
      auto front = q.front();
      q.pop();
      string word = front.first;
      int level = front.second;
      if (word == endWord) {
        return level;
      }
      for (int i = 0; i < word.size(); i++) {
        char og = word[i];
        for (int j = 0; j < 26; j++) {
          word[i] = (char)('a' + j);
          if (se.count(word) > 0) {
            se.erase(word);
            q.push({word, level + 1});
          }
        }
        word[i] = og;
      }
    }
    return 0;
  }
};
