import java.util.*;

//tc is O(n^3)
//sc is O(n)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord == null || endWord == null || wordList == null)
            return 0;

        int n = wordList.size();
        int m = beginWord.length();

        // create hashmap (adjacancy list)

        HashMap<String, List<String>> map = new HashMap<>();

        String myWord;
        for (int index = 0; index < n + 1; index++) {
            if (index == 0) {
                myWord = beginWord;
            } else {
                myWord = wordList.get(index - 1);
            }
            for (int i = 0; i < n; i++) {
                String listWord = wordList.get(i);
                int count = 0;
                for (int j = 0; j < listWord.length(); j++) {
                    if (myWord.charAt(j) != listWord.charAt(j)) {
                        count++;

                    }

                }

                if (count == 1) {
                    // there is a difference of only 1 char
                    if (!map.containsKey(myWord)) {
                        map.put(myWord, new ArrayList<>());
                    }
                    List<String> list = map.get(myWord);
                    list.add(listWord);
                    map.put(myWord, list);
                }

            }

        }

        System.out.println(map);

        // now we do BFS from map

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.add(beginWord);
        visited.add(beginWord);
        int k = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (map.containsKey(word)) {
                    List<String> list = map.get(word);
                    for (int j = 0; j < list.size(); j++) {
                        String newWord = list.get(j);

                        if (newWord.equals(endWord)) {
                            return k + 1;
                        }
                        if (!visited.contains(newWord)) {
                            q.add(newWord);
                        }
                        visited.add(newWord);

                    }
                }
            }

            k++;

        }

        return 0;
    }
}