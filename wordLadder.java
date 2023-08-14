// TC : O(m*n^2)
// SC : O(n)
// Ran on LC : Yes
// Problems : None.

class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		 Set<String> wordDict = new HashSet<>();
		 for(String s : wordList){
			  wordDict.add(s);
		 }
		 if(!wordDict.contains(endWord)){
			  return 0;
		 }
		 Set<String> visited = new HashSet<>();
		 Queue<String> queue = new LinkedList<>();
		 visited.add(beginWord);
		 queue.offer(beginWord);
		 int count = 1;
		 while(!queue.isEmpty()){
			  int size = queue.size();
			  for(int i = 0; i < size; i++){
					String current = queue.poll();
					char[] cur = current.toCharArray();
					for(int j = 0; j < cur.length; j++){
						 char c = cur[j];
						 for(char k = 'a'; k <= 'z'; k++){
							  cur[j] = k;
							  String newString = new String(cur);
							  if(newString.equals(endWord)){
									count++;
									return count;
							  }
							  if(!visited.contains(newString) && wordDict.contains(newString)){
									visited.add(newString);
									queue.offer(newString);
							  }
						 }
						 cur[j] = c;
					}
			  }
			  count++;
		 }
		 return 0;
	}
}