// Time Complexity : O((n^2) * m), n -> Length of each word in the dictionary, m -> Length of dictionary
// Space Complexity : O((n^2) * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord) || beginWord == null
				|| beginWord.equals("") || endWord == null || endWord.equals("") || endWord.equals(beginWord)) {
			return 0;
		}

		Map<String, List<String>> dictMap = new HashMap<String, List<String>>();

		for (String word : wordList) {
			int n = word.length();
			for (int i = 0; i < n; i++) {
				String regexWord = word.substring(0, i) + "?" + word.substring(i + 1, n);

				if (!dictMap.containsKey(regexWord)) {
					dictMap.put(regexWord, new ArrayList<String>());
				}
				dictMap.get(regexWord).add(word);
			}
		}

		Set<String> visited = new HashSet<String>();

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		visited.add(beginWord);

		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currWord = queue.poll();
				int n = currWord.length();
				for (int j = 0; j < n; j++) {
					String regexWord = currWord.substring(0, j) + "?" + currWord.substring(j + 1, n);
					if (dictMap.containsKey(regexWord)) {
						for (String word : dictMap.get(regexWord)) {
							if (word.equals(endWord)) {
								return level + 1;
							}

							if (!visited.contains(word)) {
								visited.add(word);
								queue.add(word);
							}
						}
					}
				}
			}
			level++;
		}

		return 0;
	}

	public static void main(String[] args) {
		WordLadder obj = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";

		List<String> dict = new ArrayList<>(Arrays.asList("hot", "lot", "cog", "dog", "log"));

		System.out.println("Number of words in the shortest transformation sequence: "
				+ obj.ladderLength(beginWord, endWord, dict));
	}

}
