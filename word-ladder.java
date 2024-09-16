// Time - O(NM^2)
// Space - O(NM)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        
        
        // Pair<String, Integer> p = new Pair<>();
        
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> s = new HashSet<>();
        wordList.forEach(word -> {
            int len = word.length();
            
            for(int i=0;i<len;i++) {
                String newWord  = word.substring(0,i) + "*" + word.substring(i+1,len);
                if(map.containsKey(newWord)) {
                     map.get(newWord).add(word);
                }
                else {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(newWord, list);
                }
               
            }
            
        });
        System.out.println(map.toString());
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()) {
            Pair<String, Integer> p = q.poll();
            String newWord = p.getKey();
            int len = p.getValue();
            
            for(int i=0;i<newWord.length();i++) {
                String word = newWord.substring(0,i) + "*" + newWord.substring(i+1, newWord.length());
                if(map.containsKey(word)) {
                    List<String> list = map.get(word);
                    for(int j=0;j<list.size();j++) {
                        String matchingWord = list.get(j);
                        if(matchingWord.equals(endWord)) {
                            return len + 1;    
                        }
                        if(!s.contains(matchingWord)) {
                            q.add(new Pair(matchingWord, len + 1));                              
                            s.add(matchingWord);
                        }
                    }
                }
            }
        }
        
        
        return 0;
        
            
    }
}
