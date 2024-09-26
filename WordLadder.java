import java.util.*;
/*
Time Complexity: O(N^2 * Number of words in the dicts), N is the each word
Space Complexity: O(N^2 * Queue), N is the word, every word in the dict has to go through the N^2 transformations
Run on leetcode: yes
Any difficulties: no

Approach:
1. I will be using Breadth First Search to solve this problem, I am gonna maintain a HashSet of all the words in the dicts
2. I will add beginWord into queue and then will transform this word using all the lowercase characters, next I will check
if the transformed word exists in the set, if that is the case I am gonna increment my ladder length count(level) and so on

 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> dicts){
        HashSet<String> set = new HashSet<>();
        for(String word: dicts){
            set.add(word);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int qSize = queue.size();
            for(int i = 0; i<qSize; i++){
                String currWord = queue.remove();
                char[] cArr = currWord.toCharArray();

                for(int j = 0; j<cArr.length; j++){
                    char temp = cArr[j];
                    for(char c = 'a'; c<= 'z'; c++){
                        if(cArr[j] == c){
                            continue;
                        }
                        cArr[j] = c;
                        String transFormedWord = String.valueOf(cArr);

                        if(endWord.equals(transFormedWord)){
                            return level+1;
                        }
                        if(set.contains(transFormedWord)){
                            queue.add(transFormedWord);
                            set.remove(transFormedWord);
                        }
                    }
                    cArr[j] = temp;
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        wordDict.add("cog");

        System.out.println(ladderLength("hit", "cog", wordDict));
    }
}
