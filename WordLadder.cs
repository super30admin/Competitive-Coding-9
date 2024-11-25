// Time Complexity : O(N.L) , L is word length and N is no. of words in wordList
// Space Complexity : O(N) for sets used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/word-ladder/description/

public class Solution {
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {

        HashSet<string> wordSet = new HashSet<string>(wordList);
    if (!wordSet.Contains(endWord)) return 0;

    HashSet<string> beginSet = new HashSet<string> { beginWord };
    HashSet<string> endSet = new HashSet<string> { endWord };
    HashSet<string> visited = new HashSet<string>();

    int level = 1;

    while (beginSet.Count > 0 && endSet.Count > 0)
    {
       

        HashSet<string> nextSet = new HashSet<string>();
        foreach (string word in beginSet)
        {
            char[] charArray = word.ToCharArray();
            for (int i = 0; i < charArray.Length; i++)
            {
                char originalChar = charArray[i];
                for (char c = 'a'; c <= 'z'; c++)
                {
                    if (c == originalChar) continue;

                    charArray[i] = c;
                    string newWord = new string(charArray);

                    if (endSet.Contains(newWord))
                    {
                        return level + 1;
                    }

                    if (wordSet.Contains(newWord) && !visited.Contains(newWord))
                    {
                        nextSet.Add(newWord);
                        visited.Add(newWord);
                    }
                }
                charArray[i] = originalChar;
            }
        }
        beginSet = nextSet;
        level++;
    }
    return 0;
        
    }
}

