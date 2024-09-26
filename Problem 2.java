//Time Complexity: O(N * M ^ 2) where N is the number of words in wordList and M is the length of beginWord
//Space Complexity: O(N * M ^ 2)

//Successfully runs on leetcode: 53 ms

//Approach: Here we are using BFS where we will modify each character starting from first character and check if the new string
//exists in the set - if it does, we put the new string in queue for further processing and so on. If the new string matches
//the endWord, we return the number of levels.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        set.remove(beginWord);
        queue.add(beginWord);
        
        int level = 0;
        while(!queue.isEmpty())
        {
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                String curr = queue.poll();
                if(curr.equals(endWord))
                    return level;
                char[] word = curr.toCharArray();
                for(int j = 0; j < word.length; j++)
                {
                    char currChar = word[j];
                    for(char character = 'a'; character <= 'z'; character++)
                    {
                        word[j] = character;
                        String newWord = new String(word);
                        if(set.contains(newWord))
                        {
                            set.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                    word[j] = currChar;
                }
            }
        }
        return 0;
    }
}