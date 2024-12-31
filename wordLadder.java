// Time complexity = O(mn)
// Space complexity = O(m+n)

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(wordList == null || wordList.size() == 0) return 0;
    Set<String> set = new HashSet<>(wordList);
    if(!set.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    int level = 1;
    while(!queue.isEmpty()) {
      int size = queue.size();

      for(int i = 0; i<size; i++) {
        String current = queue.poll();
        char[] wordArray = current.toCharArray();

        for(int j = 0; j < wordArray.length; j++) {
          char originalChar = wordArray[j];

          for(char k = 'a'; k <= 'z'; k++) {
            if(originalChar == k) continue;
            wordArray[j] = k;
            String newString = new String(wordArray);
            if(newString.equals(endWord)) return level+1;
            if(set.contains(newString)) {
              queue.add(newString);
              set.remove(newString);
            }
          }
          wordArray[j] = originalChar;
        }
      }
      level++;
    }
    return 0;
  }
}