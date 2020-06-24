//WordLadder
//time o(n*k*k)
//space o(n*k*k)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res=0;
        HashMap<String, List<String>> comb = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        
        //Fill the hashmap with different combinations
        for(String word:wordList) {
            for(int i=0;i<word.length();i++) {
                String newWord = word.substring(0,i)+"*"+word.substring(i+1);
                if(!comb.containsKey(newWord)) {
                    comb.put(newWord, new ArrayList<>());
                }
                List<String> list = comb.get(newWord);
                list.add(word);
                comb.put(newWord, list);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            res++;
            for(int k=0;k<size;k++) {
                String word = q.poll();
                if(word.equals(endWord))
                    return res;
                for(int i=0; i<word.length();i++) {
                    String newWord = word.substring(0,i)+"*"+word.substring(i+1);
                    List<String> list = comb.getOrDefault(newWord, new ArrayList<>());
                    for(String s: list) {
                        if(!visited.contains(s)) {
                            q.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}