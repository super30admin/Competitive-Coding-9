// Time Complexity:  O(n^2*m)
// Space Complexity: O(n*m)
//
// where n is umber of words, m is length of each word

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {                          // if endWord not present
            return 0;
        }
        
        Map<String, List<String>> adjList = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ladder = 1;

        wordList.add(beginWord);                                   // add begin word in word list

        // Getting adjescency list
        for(int i=0; i<wordList.size(); i++) {
            String word = wordList.get(i);                         // get words from wordList
            for(int j=0; j<word.length(); j++) {                   // get all patterns from it
                String pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length());
                if(adjList.containsKey(pattern)) {                 // if pattern present in adjescancy list
                    adjList.get(pattern).add(word);                // add word to the pattern list
                }
                else {                                             // if pattern not present in adjescancy list 
                    adjList.put(pattern, new ArrayList<>(Arrays.asList(word)));
                }
            }
        }

        queue.add(beginWord);
        visited.add(beginWord);

        // go for BFS using begin word
        while(!queue.isEmpty()) {                                  // iterate queue
            int size = queue.size();
            while(size>0) {                                        // take all elements from that time
                String word = queue.remove();
                if(word.equals(endWord)) {                         // got endWord
                    return ladder;
                }
                for(int j=0; j<word.length(); j++) {               // get pattern again
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length());
                    if(adjList.containsKey(pattern)) {             // if pattern present in adjescancy list
                        List<String> adjWords = adjList.get(pattern);
                        for(int i=0; i<adjWords.size(); i++) {     // iterate all words for that pattern
                            String adjWord = adjWords.get(i);
                            if(!visited.contains(adjWord)) {       // if not visited
                                visited.add(adjWord);              // make it visited
                                queue.add(adjWord);                // and add it to queue
                            }
                        }
                    }
                }
                size--;
            }
            ladder++;                                              // increment variable whenever we are done with all words of that time
        }

        return 0;                                                  // if we did not get word ever

    }

}







// ******************** Another method ********************


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        int count=1;
        
        for(String str : wordList) {
            wordSet.add(str);
        }
        
        if(!wordSet.contains(endWord))
            return 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                String word = queue.poll();
                for(int j=0; j<word.length(); j++) {
                    for(int k=0; k<26; k++) {                                                                // instead of storing pattern, we are getting all combinations and checking it
                        String temp = word.substring(0, j) + (char)(k+97) + word.substring(j+1);
                        if(wordSet.contains(temp)) {
                            System.out.println("word: "+word+" -> "+"temp: "+temp);
                            if(temp.equals(endWord)) {
                                return count+1;
                            }
                            if(!set.contains(temp)) {
                                System.out.println("Inside** word: "+word+" -> "+"temp: "+temp);
                                set.add(temp);    
                                queue.add(temp);
                            }
                        }
                    }
                }
                size--;                
            }
            count++;
        }
        return 0;
    }
}
