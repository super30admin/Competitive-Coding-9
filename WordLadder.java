import java.util.*;

public class WordLadder {
    // BFS Approach
    /*
        For each character in beginWord, try changing the letter
        if it is there in the set, it is one of the words in the dictionary
        remove it from the set and add it to the queue
        Each word in the queue will have the same process and if we find a match with endWord, we got the answer
        Why? step + 1 -> we are expected to return the number of words in the transformation
        e.g. hit -> hot   Here, we got the answer in two steps but in the code, we are incrementing that value only if we pick a new element from the queue
     */
    // TC : O(l * w) -> l - length of each word  w - number of words
    // SC : O(w)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList); // to hold the unique words in a dictionary
        Queue<String> queue = new LinkedList<>();  // queue will hold the element being processed
        queue.add(beginWord);

        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i < size; i++) {
                String curr = queue.poll();

                for(int j=0; j < endWord.length(); j++) {
                    for(char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder tempWord = new StringBuilder(curr);
                        tempWord.setCharAt(j,letter);

                        if(set.contains(tempWord.toString())){
                            if(tempWord.toString().equals(endWord))
                                return step + 1;

                            set.remove(tempWord.toString()); // marking this word as visited
                            queue.add(tempWord.toString());  // adding in a queue to process it next time
                        }
                    }
                }

            }
            step++;
        }
        return 0;
    }
}
