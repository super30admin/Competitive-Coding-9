import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


//TC: O(n^2 * m) [n: number of words; m: length of words]
//Sc: O(m * n)
class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(end)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.offer(begin);

        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int changes = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(end)) {
                    return changes;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char arr[] = word.toCharArray();

                        arr[j] = (char) k;

                        String inter = new String(arr);

                        if (set.contains(inter) && !visited.contains(inter)) {
                            q.offer(inter);
                            visited.add(inter);
                        }
                    }
                }
            }
            ++changes;
        }

        return 0;

    }
}