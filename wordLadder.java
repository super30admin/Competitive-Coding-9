import java.util.*;

class Main {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // list -> map
        HashSet<String> set = new HashSet<>(wordList);
        // q for BFS
        Queue<String> q = new LinkedList<>();
        // add beginword(root) in the queue
        q.add(beginWord);
        // intially level would be 1 as we are at root level
        int level = 1;
        // BFS traversal
        while (!q.isEmpty()) {
            // increase the level as we are at first children at particular node
            level++;
            // level
            int size = q.size();
            // for loop level traversal
            for (int i = 0; i < size; i++) {
                // current string
                String curr = q.poll();
                // System.out.println(curr);
                // convert this into the array of chars
                char[] temp = curr.toCharArray();
                // manipulate each character and check if is available in our set or not
                for (int j = 0; j < temp.length; j++) {
                    // System.out.println(new String(temp));
                    // to get back to original word
                    char c = temp[j];
                    for (int k = 0; k < 26; k++) {
                        // char type casting
                        temp[j] = (char) (k + 'a');
                        // convert this into string
                        String key = new String(temp);
                        // System.out.println(key);
                        // here first check set contains this value and if it is end word return level
                        if (set.contains(key) && key.equals(endWord)) {
                            return level;
                        }
                        // here check if set contains updated key then add into queue and remove from
                        // the set
                        // as we make sure not repeat
                        if (set.contains(key)) {
                            q.add(key);
                            set.remove(key);
                        }
                    }

                    // get back to original string
                    temp[j] = c;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}