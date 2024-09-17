// Time complexity: O(M * N) 
// Space complexity: O(M) 
// Where M is the no. of words and N is the average length of words.

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        Set<String> dict = new HashSet<>(wordList);

	int len = 1;
	// int strLen = beginWord.length();
	HashSet<String> visited = new HashSet<String>();
	
	beginSet.add(beginWord);
	endSet.add(endWord);
	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
		if (beginSet.size() > endSet.size()) {
			Set<String> set = beginSet;
			beginSet = endSet;
			endSet = set;
		}
        // System.out.println("begin " + beginSet);

		Set<String> temp = new HashSet<String>();
		for (String word : beginSet) {  //hot dot
			char[] chs = word.toCharArray(); //temp -> lot

			for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {		
					chs[i] = c;
					String target = String.valueOf(chs); 

					if (endSet.contains(target)) {
						return len + 1;
					}

					if (!visited.contains(target) && dict.contains(target)) {
						temp.add(target);
						visited.add(target);
					}
					
				}
                chs[i] = old;
			}
		}

		beginSet = temp;

		len++;
	}
	
	return 0;
}
}