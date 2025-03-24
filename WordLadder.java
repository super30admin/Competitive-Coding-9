class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
        {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int steps =1;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String currentWord = q.poll();

                for(int j=0;j<currentWord.length();j++)
                {
                    char [] charArray = currentWord.toCharArray();

                    for(char c ='a'; c<='z';c++)
                    {
                        charArray[j] = c;
                        String nextWord = new String(charArray);
                        if(wordSet.contains(nextWord))
                        {
                            if(nextWord.equals(endWord))
                            {
                                return steps+1;
                            }
                            if(!visited.contains(nextWord))
                            {
                                visited.add(nextWord);
                                q.offer(nextWord);
                            }
                        }
                    }
                }
            }
            steps++;
        }

        return 0;

    }
}


// Time Complexity : O(n X l)
// Space Complexity :O(n)
//where: n is the number of words in the wordList, L is the length of each word in the list.


