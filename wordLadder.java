/**
TC: O(m*n) where m: avg length of words in wordList, n: total no of words in wordList.
SC: O(m*n) for storing all the words in set.
Approach: i parse through the word list and keep on adding the words in my set and simultaneously have a flag to detect the endWord. Once all the words are parsed, i check the endWord flag and if it is false then i return 0 which indicates that endWord is not present in the wordList.
Now a initialize a queue and add the beginWord and distance i.e 1. Run until queue is empty or endWord is found, at each i create combinations of the currWord and check if it is present in my set or not, if it is present then i add the currWord to the queue with distance+1.
 */

class Solution {
    HashSet<String> set = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean endWordFound = false;
        for(String word : wordList){
            set.add(word);
            if(endWord.equals(word)) endWordFound = true;
        }    

        if(!endWordFound) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair pair = q.poll();
            String curr = pair.word;            
            int distance = pair.dist;

            for(int i =0; i < curr.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    String newWord = curr.substring(0,i) + ch + curr.substring(i+1);
                    if(newWord.equals(endWord)) return distance+1;

                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, distance + 1));
                        set.remove(newWord);    
                    }
                }
            }

        }

    return 0;
    }


    class Pair{
        String word;
        int dist;

        public Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }
}