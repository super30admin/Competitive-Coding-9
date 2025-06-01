import java.util.*;
// Time complexity : O(N*M*26)
// Space :O(1)
public class problem2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet= new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){return 0;}

        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        int level=1;

        while(!queue.isEmpty())
        {
            int size= queue.size();
            //go thru one level of words
            for (int i=0;i<size;i++)
            {
                String word= queue.poll();

                // try all possible one level transformations
                for (int j=0;i<word.length();j++)
                {
                    char[] chars= word.toCharArray();
                    for (char c='a'; c<='z';c++)
                    {
                        chars[j]= c;
                        String newWord= new String(chars);

                        if (newWord.equals(endWord))
                        {
                            return level+1;
                        }
                        if (wordSet.contains(newWord))
                        {
                            queue.add(newWord);
                            wordSet.remove(newWord); // avoid revisting
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
