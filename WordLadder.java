// Time Complexity : O(m ^ 2 * n) // m = length of the word, n = number of words
// Space Complexity : O(m * n)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 2;
        
        int count = 1;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: wordList){
            for(int i = 0; i < word.length(); i++){
                String key = word.substring(0,i) + "*" + word.substring(i + 1);
                if(!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.add(beginWord);
        visited.add(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                String str = q.poll();
                for(int j = 0; j < str.length(); j++){
                    String key = str.substring(0,j) + "*" + str.substring(j + 1);
                    if(map.containsKey(key)){
                        for(String nextstr: map.get(key)){
                            if(endWord.equals(nextstr))
                                return count;
                            if(!visited.contains(nextstr)){
                                q.add(nextstr);
                                visited.add(nextstr);
                            }
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}