class Solution {
    class Pair {
        String word;
        int level;
        
        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<wordList.size();i++){
            if(nextString(beginWord, wordList.get(i))){
                List<String> l = hm.getOrDefault(beginWord, new ArrayList<>());
                l.add(wordList.get(i));
                hm.put(beginWord, l);
            }
        }
        
        for(int i=0; i<wordList.size();i++){
            for(int j=0;j<wordList.size(); j++){
                if(nextString(wordList.get(i), wordList.get(j))){
                    List<String> l = hm.getOrDefault(wordList.get(i), new ArrayList<>());
                    l.add(wordList.get(j));
                    hm.put(wordList.get(i), l);
                }
            }
        }
        
       
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;
            if(hm.containsKey(word)){
            for (String s : hm.get(word)) {
                if (s.equals(endWord)) {
                    return level + 1;
                }
                
                if (!visited.containsKey(s)) {
                    visited.put(s, true);
                    queue.add(new Pair(s, level + 1));
                }
            }
        }
        }
        return 0;
        
    }
    public boolean nextString(String s1, String s2){
        int count=0;
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i)) count++;
        }
        if(count == s1.length()-1)
            return true;
        return false;
    }
}

//Time complexity : O(N^2)
//Space complexity : O(N) where N is the number of words
