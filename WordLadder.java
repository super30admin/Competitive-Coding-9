// Time Complexity: O(n*n*m)
// Space Complexity: O(n * m) n - wordList

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> dict = new HashMap<>();

        for (String string : wordList) {
            StringBuilder sb = new StringBuilder(string);
            for (int i = 0; i < string.length(); i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, '*');
                if (dict.containsKey(sb.toString()))
                    dict.get(sb.toString()).add(string);
                else {
                    dict.put(sb.toString(), new ArrayList<>());
                    dict.get(sb.toString()).add(string);
                }
                sb.setCharAt(i, c);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int minSteps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord))
                    return minSteps + 1;

                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    sb.setCharAt(j, '*');
                    if (dict.containsKey(sb.toString()))
                        for (String string : dict.get(sb.toString()))
                            q.add(string);

                    dict.remove(sb.toString());
                    sb.setCharAt(j, c);
                }
            }
            minSteps++;
        }

        return 0;
    }
}