import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Map<String, List<String>> map = new HashMap<>();

		int wordLength = beginWord.length();
		
		for (String word : wordList) {
			for (int i = 0; i < wordLength; i++) {
				map.compute(word.substring(0, i) + "*" + word.substring(i + 1, wordLength),
						(k, v) -> v == null ? new ArrayList<String>() : v).add(word);
			}
		}

		Queue<String> queue = new LinkedList<>();
		Map<String, Boolean> visited = new HashMap<>();

		queue.offer(beginWord);
		visited.put(beginWord, true);

		int level = 0;

		while (!queue.isEmpty()) {
			level++;
			String word = queue.poll();
			for (int i = 0; i < wordLength; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);

				if (map.containsKey(newWord)) {
					for (String adjWord : map.get(newWord)) {
						if (adjWord.equals(endWord))
							return level;
						if (!visited.containsKey(adjWord)) {
							visited.put(adjWord, true);
							queue.offer(adjWord);
						}
					}
				}
			}
		}

		return 0;
	}
	
	public static void main(String[] args) {
		List<String> dict=new ArrayList<>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		System.out.println(new WordLadder().ladderLength("hot", "dog", dict));
	}
}
