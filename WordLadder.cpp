// Time Complexity : O(n*m) where n is numbeer of words and m is maximum size of word.
// Space Complexity : O(n) space for the head and queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

/*

    * 1. Get the size of a queue at current level
        * 2. For all the words at a current level, poll the front as current word from queue
        * 3. Since, Strings in JAVA are immutable, convert the current word to character array
        * 4. For each character in array for a current word:
        *       1. First, store the original character in a variable to recover it later
        *       2. loop through all the 'a' to 'z' characters in alphabet and replace original character with it to try out all the possibilities for next transformation
        *           1. If original character is same as current alphabet, ignore it, continue;
        *           2. If not, replace original character with current alphabet
        *           3. Convert the current character array to string
        *           4. If the new word is equal to endWord, we reached destination, return length of shortest transformation sequence as level + 1, as the next word will be at level below the current level
        *           5. If new word is eligible for next transformation, present in a set, then add to queue to process it later, and remove it from set to avoid duplicates
        *           6.Increment the character in alphabet and repeat above steps
        *       3. Once all characters in alphabet are done, restore the original character in word_chars array
        *       4. Move on to the next character to replace in 'word_chars' array
        *       5. Once, we are done with all the characters in a 'word_chars' array for a current word, poll the next word from queue at current level and repeat all the same steps
        *       6. If all words at current level are processed, then go to next level, level++
        *       7. If endWord is not found, return 0
        */

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList)
    {
     
        set<string> myset;
        for(auto i:wordList)
            myset.insert(i);
        queue<string> myqueue;
        if(myset.find(endWord)==myset.end()){
            return 0;
        }
        myqueue.push(beginWord);
        int result=0;
        while(!myqueue.empty())
        {
            result++;
            int n=myqueue.size();
            while(n!=0)
            {
                string curr=myqueue.front();
                myqueue.pop();
                for(int i=0; i<curr.length(); i++)
                {
                    string updated=curr;
                    for(char ch ='a';ch <='z'; ch++)
                    {
                        updated[i]=ch;
        
                        if(updated==endWord)
                            return result+1;
                        if(myset.find(updated)!=myset.end())
                        {
                            myqueue.push(updated);
                            myset.erase(updated);
                        }
                    }
                }
                n--;
            }
        }
        return 0;
    }
};
