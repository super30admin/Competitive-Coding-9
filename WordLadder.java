//Map - HashMap to store various alterations of the word with * in position of different characters
//Time - O(M^2 x N) - M length of ecah word, N size of wordList
//Space - O(M^2 x N)

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    Map<String, List<String>> allComboDict = new HashMap<>();

    int size = beginWord.length();

    for(String word: wordList){
      for(int i=0; i<size; i++){

        String alteredWord = word.substring(0, i)+"*"+word.substring(i+1, size);
        List<String> combos = allComboDict.getOrDefault(alteredWord, new ArrayList<String>());

        combos.add(word);
        allComboDict.put(alteredWord, combos);
      }
    }

    Queue<Pair<String, Integer>> queue = new LinkedList<>();
    queue.add(new Pair(beginWord, 1));

    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while(!queue.isEmpty()){

      Pair<String, Integer> node = queue.poll();
      String word = node.getKey();
      Integer level = node.getValue();

      for(int i=0; i<size; i++){

        String alteredWord = word.substring(0, i)+"*"+word.substring(i+1, size);

        for(String combo: allComboDict.getOrDefault(alteredWord, new ArrayList<String>())){
          if(combo.equals(endWord)){
            return level+1;
          }

          if(!visited.containsKey(combo)){
            visited.put(combo, true);
            queue.add(new Pair(combo, level+1));
          }
        }
      }
    }
    return 0;
  }
}
