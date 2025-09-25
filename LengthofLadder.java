import java.util.*;
//Idea is to use bfs traversal to find the shortest path to reach from begin word to end word
//Time Complexity O(kn) -, where k is the length of the word and n is the length of wordlist
//Space Complexity - O(n)
class LengthofLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            words.add(wordList.get(i));
        }
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return length;
                }
                char[] charArray = temp.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char ch = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) {
                            continue;
                        }
                        charArray[j] = c;
                        String newWord = new String(charArray);
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    charArray[j] = ch;
                }
            }
            length++;
        }
        return 0;
    }
}

