import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Time Complexity : O(N^2 * M)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * Push the begin word to the queue. Then iterate till the size of the queue to
 * find the neighbor words to the current word. To generate neighbors, we have
 * to replace all the positions with a to z and generate new strings. Push all
 * the neighbors to the queue and repeat the process until the end word is
 * found. At each iteration of size of queue increment level. return that level.
 *
 */
class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordsSet = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		int level = 0;
		queue.add(beginWord);
		wordsSet.remove(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			for (int i = 0; i < size; i++) {
				String s = queue.poll();
				if (s.equals(endWord))
					return level;
				List<String> neighborsList = neighbors(s);
				for (String neighbor : neighborsList) {
					if (wordsSet.contains(neighbor)) {
						queue.add(neighbor);
						wordsSet.remove(neighbor);
					}
				}
			}
		}
		return 0;
	}

	public List<String> neighbors(String word) {
		List<String> ans = new ArrayList<>();
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char temp = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				chars[i] = c;
				ans.add(new String(chars));
			}
			chars[i] = temp;
		}
		return ans;
	}
}
