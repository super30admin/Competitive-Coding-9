// Time complexity is O(n)
// Space complexity is O(n)
// This solution is submitted on leetcode

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN119WordLadder {
	class Solution {
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			// edge case
			if (beginWord.length() == 0 || beginWord == null || endWord == null || endWord.length() == 0)
				return 0;
			HashSet<String> set = new HashSet<>();
			// filling the hashset
			for (String s : wordList) {
				set.add(s);
			}

			// edge case of last letter not in the queue
			if (!set.contains(endWord))
				return 0;
			Queue<String> q = new LinkedList<>();
			q.offer(beginWord);
			int level = 1;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int k = 0; k < size; k++) {
					String current = q.poll();
					char[] currentChar = current.toCharArray();
					for (int i = 0; i < currentChar.length; i++) {
						char test = currentChar[i];
						for (char c = 'a'; c < 'z'; c++) {
							if (currentChar[i] == c)
								continue;
							currentChar[i] = c;
							String testing = String.valueOf(currentChar);
							if (testing.equals(endWord))
								return level + 1;
							if (set.contains(testing)) {
								q.offer(testing);
								set.remove(testing);
							}
						}
						currentChar[i] = test;
					}
				}
				level++;
			}
			return 0;
		}
	}
}