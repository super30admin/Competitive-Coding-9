// time complexity - where m is length of word list and n is avg length of word
// O(mn) - for BFS and to check each char in string, O(n) - forming each replaced string) 
// O(mn^2)
// space complexity - O(mn). Queue, set storage for each word
// Approach - BFS - Put word list in set. Use BFS to find shortest sequence
// for each string try replacing each char with other 25 chars and if the replacement string is present 
// in set, add it to BFS and remove it from set so that same string can not be processed again.
// when the replaced string is same as end string, break. At each level of BFS increase count which finally
// gives the shortest sequence

public class Solution
{
    public int LadderLength(string beginWord, string endWord, IList<string> wordList)
    {
        int res = 1;
        Queue<string> bfs = new Queue<string>();
        HashSet<string> hs = new HashSet<string>();
        foreach (string str in wordList)
        {
            hs.Add(str);
        }

        bfs.Enqueue(beginWord);
        while (bfs.Count() > 0) // O(mn)
        {
            int size = bfs.Count();
            while (size > 0)
            {
                string currStr = bfs.Dequeue();
                if (endWord == currStr)
                {
                    return res;
                }
                for (int i = 0; i < currStr.Length; i++)
                {
                    for (int j = 0; j <= 25; j++)
                    {
                        if (currStr[i] != 'a' + j)
                        {
                            StringBuilder sb = new StringBuilder(currStr);
                            sb[i] = (char)('a' + j);
                            string replaced = sb.ToString();
                            if (hs.Contains(replaced)) // O(n)
                            {
                                bfs.Enqueue(replaced);
                                hs.Remove(replaced);
                            }
                        }
                    }
                }
                size--;
            }
            res++;
        }

        return 0;
    }
}