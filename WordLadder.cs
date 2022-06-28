using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(M2×N), where MM is the length of each word and NN is the total number of words in the input word list.
    // Space Complexity :O(M2×N), where MM is the length of each word and NN is the total number of words in the input word list.
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class WordLadder
    {
        public int LadderLength(string beginWord, string endWord, IList<string> wordList)
        {
            HashSet<string> set = new HashSet<string>(wordList);
            if (beginWord == endWord)
                return 0;
            if (!set.Contains(endWord))
                return 0;

            int minNumberOfTransactions = 0, wordlength = beginWord.Length;

            Queue<string> q = new Queue<string>();
            q.Enqueue(beginWord);

            while (q.Count != 0)
            {
                minNumberOfTransactions++;
                int size = q.Count;
                for (int i = 0; i < size; ++i)
                {
                    char[] currWord = q.Dequeue().ToCharArray();

                    for (int pos = 0; pos < wordlength; ++pos)
                    {
                        char orig_char = currWord[pos];
                        for (char c = 'a'; c <= 'z'; ++c)
                        {
                            currWord[pos] = c;

                            if (String.Join("", currWord).Equals(endWord))
                                return minNumberOfTransactions + 1;

                            if (!set.Contains(String.Join("", currWord)))
                                continue;
                            set.Remove(String.Join("", currWord));

                            q.Enqueue(String.Join("", currWord));
                        }
                        currWord[pos] = orig_char;
                    }
                }
            }
            return 0;

        }
    }
}
