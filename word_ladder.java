class Solution {
    class Pair {
        String word;
        int level;
        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<wordList.size();i++) {
            set.add(wordList.get(i));
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            String initialWord = current.word;
            int sequenceNumber = current.level;
            if(initialWord.equals(endWord)) {
                return sequenceNumber;
            }
                for(Iterator<String> it = set.iterator();it.hasNext();) {
                    String eachWord = it.next();
                    int z=0; 
                    int counter =0;
                    while(z < eachWord.length()) {
                        if(eachWord.charAt(z) != initialWord.charAt(z)) {
                            counter++;
                        }
                        z++;
                    }
                    if(counter > 1) {
                        continue;
                    } else if(counter == 1) {
                       queue.add(new Pair(eachWord, sequenceNumber+1));
                       it.remove(eachWord);
                       
                        } else {
                             it.remove(eachWord);
                        }
                    } 

                }
        return 0;
    }
}