/*

The idea is to calculate use breath first search to get all possible character for each letter.

///////////////////////////////////////////
//Time - O(M^2 x N) - M length of each word, N size of wordList
//Space - O(M^2 x N)
///////////////////////////////////////////

*/

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        set<string> set;
        for ( auto word: wordList) set.insert(word);
        queue<string> queue;
        queue.push(beginWord);
        int level = 1;
        while ( queue.size()!= 0){
            int size = queue.size();
            for ( int i =0; i < size; i++){ 
                auto currString = queue.front();
                queue.pop();
                string originalString = currString;
                for ( int j =0; j < currString.size(); j++){
                    for ( int k =0; k < 26; k++){
                        currString = originalString;
                        currString[j] = 'a' + k;

                        if (currString == endWord and set.find(currString) != set.end()) return level+1;  
                        
                        if ( set.find(currString) != set.end()){
                            queue.push(currString);
                            set.erase(currString);
                        } 
                    }
                }
            }
            level++;
        }
        return 0;
    }
};