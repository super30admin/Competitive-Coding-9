//TC = O(nm^2)
//SC = O(V+E)

import java.util.*;
public class WordLadder
{
    public  static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) return 0;
        
        Map<String,List<String>> adjList = new HashMap<String,List<String>>();
        
        wordList.add(beginWord);
        
        int l = beginWord.length();
        
        wordList.forEach(word-> {
           for(int i =0;i<l;i++)
           {
               adjList.computeIfAbsent(findPatten(word,i,l),k-> new ArrayList<>()).add(word);
           }
        });
        
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        
        int level = 1;
        
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            
            for(int i =0;i<qSize;i++)
            {
                String wordFromQ = queue.poll();
                
                if(wordFromQ.equals(endWord)){
                    return level;
                }
                
                for(int j =0;j<l;j++)
                {
                    String pattern = findPatten(wordFromQ,j,l);
                    
                    
                    adjList.get(pattern).forEach(adjWrd -> {
                            if(!visited.contains(adjWrd)) {
                                queue.offer(adjWrd);
                                visited.add(adjWrd);
                            }
                        });
                }
            }
            level++;
        }
        return 0;
    }
     private static String findPatten(String originalWord, int index, int maxLength) {
        return originalWord.substring(0, index) + "*" + originalWord.substring(index+1, maxLength);
    }

    public static void main(String args[])
    {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength("hit", "cog", wordList));
    }
}