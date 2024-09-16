/*
Time Complexity: O(L * N) where L is the length of each word and N is the number of words.
Space Complexity: O(L * N) all possible transoformation present in the wordList
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        /*If endWord is not present in the list there is no point in creating a sequence*/
        if(!wordList.contains(endWord))
            return 0;
        
        /* Using queue to maintain level for transformation of each word*/
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int result = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i< size; i++)
            {
                String current = queue.poll();
                
                /* if the current word is itsefl the endword stop the search*/
                if(current.equals(endWord))
                {
                    return result + 1;
                }
                
                /* Now change every single char and compare it with words present in the wordList*/
                for(int x=0; x<current.length(); x++)
                {
                    char[] currentWord = current.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++)
                    {
                        currentWord[x] = ch;
                        String newWord = String.valueOf(currentWord);
                        if(wordSet.contains(newWord) && !newWord.equals(current))
                        {
                            System.out.println("New: "+newWord);
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }  
                }
                
                
            }
            
          result++;  
        }
        
        return 0;
    }
}
