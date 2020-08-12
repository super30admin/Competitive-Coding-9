// Time Complexity: O(m^2 * n) 
// Space Complexity: O(m^2 * n) 
class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>();
		for (String str : wordList) {
			set.add(str);
		}
		if (!set.contains(endWord))
			return 0;
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr_word = q.poll();
				char[] word_chars = curr_word.toCharArray();
				for (int j = 0; j < word_chars.length; j++) {
					char original_char = word_chars[j];
					for (char c = 'a'; c < 'z'; c++) {
						if (word_chars[j] == c)
							continue;
						word_chars[j] = c;
						String new_Word = String.valueOf(word_chars);
						if (new_Word.equals(endWord))
							return count + 1;
						if (set.contains(new_Word)) {
							q.add(new_Word);
							set.remove(new_Word);
						}
					}
					word_chars[j] = original_char;
				}
			}
			count++;
		}
		return 0;
	}
} 