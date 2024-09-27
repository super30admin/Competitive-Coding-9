// Time Complexity : O(m^2*n) where m is the number of characters and n is the number of words
// Space Complexity : O(m^2*n + n)  where m is the number of characters and n is the number of words in the Graph (HashMap) and n words in the visited set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I thought of Tries and DP initially, but BFS is a good solution.
/* Your code here along with comments explaining your approach: If we notice the pattern, its a graph pattern where the words area connected to each
other by just one transformation. We can create m intermediate words of a single word with * symbol at m different positions. We can store the possible
words that can be formed from the word list and a hashmap can be made like that. We start from the begin word and put it in the queue. For the start
word, we create the possible word that can be formed using * at all the m positions and come up with a equivalent word that have list of words as its value
tp be explored further. We further create a * at all the m positions of the new equivalent word and from the graph we get the further similar words.
We repeat it level by level and return the level where the end word is found.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null){return 0;}
        HashMap<String, ArrayList<String>> store = new HashMap<>();                                             // Store word with * and possible formed words
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<String>();                                                             // Queue to processes level by level
        int length = beginWord.length();
        for(String s: wordList){
            for(int j = 0; j < length; j++){
                String w = s.substring(0,j) + "*" + s.substring(j+1, length);                                       // Use * at all m positions
                    ArrayList<String> str = store.getOrDefault(w, new ArrayList<String>());
                    str.add(s);
                    store.put(w, str);
                }
            }
        System.out.println(store);
        q.add(beginWord);
        int level  = 0;
        visited.add(beginWord);                                                                                 // Seen words not be visited again
        while(!q.isEmpty()){
              level++;                                                                                          // Process at each level
              int size = q.size();
              for(int j = 0; j < size; j++){                                                                            // Size pointer to process a group of words at an instant 
              String word = q.poll();
              if(word.equals(endWord)){return level;}
              for(int i =0 ; i < length; i++){
              String wrd = word.substring(0,i)+ "*"+word.substring(i+1, length);                                    // Convert the word to its possible * formations
              for(String w1 : store.getOrDefault(wrd, new ArrayList<>())){                                      // Get the further similar words to be explored
                  if(!visited.contains(w1)){
                      visited.add(w1);                                                                              // Add to seen set
                      q.add(w1);                                                                                    // Add to Queue
                  }
              }
              }
              }
          }  
        return 0;                                                                                                   // No transformation needed
    }
}