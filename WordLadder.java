import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> bfsQ = new LinkedList<>();
        bfsQ.add(beginWord);

        if(!wordSet.contains(endWord)){
            return 0;
        }

        int count = 1;
        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            for(int i = 0; i < size ;i++){
                String currString = bfsQ.poll();
                char[] currS_arr = currString.toCharArray();
                for(int j = 0; j < currString.length(); j++){
                    char temp = currS_arr[j];
                    for(char k = 'a'; k <='z';k++){
                        //'h' == 'h' - > move to next char 'i'
                        if(currS_arr[j] == k ) continue;
                        currS_arr[j] = k; // new transformed word
                        String tWord = new String(currS_arr);
                        if(tWord.equals(endWord)) return count + 1;
                        if(wordSet.contains(tWord)){
                            bfsQ.add(tWord);
                            wordSet.remove(tWord);
                        }
                    }
                    currS_arr[j] = temp;
                }
            }
            count++;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        new WordLadder().ladderLength("hit", "cog", wordList);
    }
}
