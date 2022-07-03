// Time : O(M^2*N) | Space : O(M^2*N)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        // loading adjList with all the possiblities of a certain word
        // that can be made out of a different words from the dictionary by changing one character at a time
        for(String w: wordList) {
            int wordLength = w.length();
            for(int i=0;i<wordLength;i++) {
                String adjKey = w.substring(0,i)+"*"+w.substring(i+1, wordLength);
                if(!adjList.containsKey(adjKey))
                    adjList.put(adjKey, new ArrayList<>());
                adjList.get(adjKey).add(w);
            }
        }
        int level = 0;
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int qSize = q.size();
            level++;
            for(int k=0;k<qSize;k++) { // M
                String w = q.poll();
                for(int i=0;i<w.length();i++) { // M
                    String adjKey = w.substring(0,i)+"*"+w.substring(i+1, w.length());
                    if(adjList.containsKey(adjKey)) {
                        for(String adjWord: adjList.get(adjKey)) { // L
                            if(!visited.contains(adjWord)) {
                                visited.add(adjWord);
                                if(adjWord.equals(endWord)) return level+1;
                                q.add(adjWord);
                            }

                        }
                    }
                }
            }
        }
        return 0;
    }
}