// Time Complexity:  O(n * m * 26 * m) -> O(26nm^2) - > O(nm^2)
// Space Complexity: O(n * m + n * m ) -> O(2mn) -> O(mn)
public class WordLadder {
    Set<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null)
            return 0;
        
        visited = new HashSet<String>(wordList);
        int min = 1;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        while(!q.isEmpty()) // O(n) where n is number of words and all could end up in queue incase not found
        {
            int size = q.size();
            for(int i = 0 ; i < size; i ++)
            {
                String curr = q.poll();
                if(curr.equals(endWord)) // O(m) length of string
                {
                   return min;
                }
                else
                {
                    // get permutation of the curr word
                    // check if it is in dict and not visited
                    List<String> result = permutation(curr); // O(m)
                    if(!result.isEmpty())
                    { 
                        for(String per : result)
                        {
                            q.add(per);
                        }
                    }
                }
            }
            min++;   
        }
        
        return 0;
    }
    
    
    // convert to char array + each char 26 permutation 
    // O(m) + O(m * 26) -> O(27m) -> O(m)
    private List<String> permutation(String curr)
    {
        List<String> neigh = new ArrayList<>();
        char [] currChars = curr.toCharArray(); // O(m) convert to array
        for (int i = 0; i < curr.length(); i++) // O(m) for each char 
        {
            // keep it in temp so that we can restore it
            char orgChar = currChars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) // O(26)
            {
                currChars[i] = ch;
                String word = new String(currChars);
                if (visited.contains(word)) // O(1)
                {
                   neigh.add(word);
                   visited.remove(word);
                }
            }
            // restore char
            currChars[i] = orgChar;
        }
       
        return neigh;
    }  
}

// Time Complexity:  O(n * m * 26 * m) -> O(26nm^2) - > O(nm^2)
// Space Complexity: O(n * m + n * m ) -> O(2mn) -> O(mn)
public class WordLadder {
    Set<String> visited;
    Map<String, List<String>> map;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null)
            return 0;
        
         map = new HashMap<>();
        // add elements to map
        populateMap(wordList);
        
        visited = new HashSet<String>(wordList);
        
        int min = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i ++)
            {
                String curr = q.poll();
                if(curr.equals(endWord))
                {
                   return min;
                }
                else
                {
                    // get permutation of the curr word
                    // check if it is in dict and not visited
                  for(int j = 0 ; j < curr.length(); j++) // O(m)
                  {
                        // make patterns of curr word
                        char [] wordChars = curr.toCharArray();
                        wordChars[j] = '*';
                        String key = new String(wordChars);
                        if(map.containsKey(key))
                        {
                            List<String> neighbors = map.get(key);
                            for(String word : neighbors) // O(n)
                            {
                                if(visited.contains(word))
                                {
                                    q.add(word);
                                    visited.remove(word);
                                }
                            }
                        }
                    }
                     
                }
            }
            min++;   
        }
        return 0;
    }
    
    private void populateMap(List<String> wordList)
    {
        for(String word: wordList) // O(n)
        {
            for(int i = 0 ; i < word.length(); i++) // O(m)
            {
                char [] wordChars = word.toCharArray();
                wordChars[i] = '*';
                String key = new String(wordChars);
                if(!map.containsKey(key))
                {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(word);
            }
        }
        System.out.println(map.toString());
    }
}