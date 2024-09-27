// Time Complexity :O(lenOfWords * No.Of Wprds in wordslist)
// Space Complexity :O(lenOfWords * No.Of Wprds in wordslist)
// Did this code successfully run on Leetcode :Yes
//Runtime: 81 ms, faster than 37.89% of Java online submissions for Word Ladder.
//Memory Usage: 51.6 MB, less than 5.11% of Java online submissions for Word Ladder.
// Any problem you faced while coding this :Had troubles in coding 


// Your code here along with comments explaining your approach


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, ArrayList<String>> allDic = new HashMap<>();
        
        Queue< Pair< String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        q.add(new Pair (beginWord,1));
        int len= beginWord.length();
        
        for(String w : wordList){
            for(int j=0; j< len; j++ ){
                String word = w.substring(0, j) + '*' + w.substring(j+1, len);
                ArrayList<String> list = allDic.getOrDefault(word, new ArrayList<>());
                list.add(w); 
                allDic.put(word,list );
            }
        }
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while(!q.isEmpty()){
            Pair<String, Integer> pair = q.remove();
            String word = pair.getKey();
            System.out.println(word);
            int level = pair.getValue();
            for(int i=0; i< len; i++){
                 String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                 for(String adjWord :allDic.getOrDefault(newWord, new ArrayList<String>()) ){
                     if(adjWord.equals(endWord)) return level+1;
                     if(!visited.containsKey(adjWord)) {
                         visited.put(adjWord, true);
                         q.add(new Pair(adjWord, level+1));
                     }
                 }

            }
        }
        return 0;
    }
}

