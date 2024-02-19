/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : YES LITTLE BIT WHILE CODING EDGECASES
* 
* Time Complexity: O(W * (l^2))
    W - words in wordList
    l - length of the each word
* 
* Space Complexity: O(W)
    W - words in wordList
* 
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean end = false;

        for (int index = 0; index < wordList.size(); index++) {
            if (wordList.get(index).equals(endWord)) {
                end = true;
            }
        }

        if (!end) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        int n = wordList.size();

        boolean[] isVisited = new boolean[n];

        queue.add(beginWord);

        for (int index = 0; index < wordList.size(); index++) {
            if (wordList.get(index).equals(beginWord)) {
                isVisited[index] = true;
            }
        }

        int minSteps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            String word = "";

            for (int elements = 0; elements < size; elements++) {
                word = queue.poll();

                if (word.equals(endWord)) {
                    return minSteps + 1;
                }

                for (int index = 0; index < n; index++) {
                    if (!isVisited[index]) {
                        String wordInDict = wordList.get(index);

                        if (wordInDict.length() != word.length()) {
                            continue;
                        }

                        int charDiff = 0;

                        for (int i = 0; i < word.length(); i++) {
                            if (wordInDict.charAt(i) != word.charAt(i)) {
                                charDiff++;
                            }

                            if (charDiff > 1) {
                                break;
                            }
                        }

                        if (charDiff == 1) {
                            queue.add(wordInDict);
                            isVisited[index] = true;
                        }
                    }
                }
            }

            minSteps++;
        }

        return 0;
    }

}
