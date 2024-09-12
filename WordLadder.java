class Solution {
    Queue<String> queue = new LinkedList<>();
    Set<String> visitedSet = new HashSet<>();
    int count=0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        queue.add(beginWord);
        visitedSet.add(beginWord);
        while(!queue.isEmpty()){
            for(int i=queue.size();i>0;i--)
            {
                beginWord = queue.poll();
                if(beginWord.equals(endWord)) {
                    return count+1;
                }
                visitedSet.add(beginWord);
                findPair(beginWord,wordList);
            }
            count++;

        }

        return 0;
    }
    public void findPair(String beginWord, List<String> wordList) {
        for(int i=0; i<wordList.size(); i++) {
            if(visitedSet.contains(wordList.get(i))){
                continue;
            }
            int k = 0;
            int x = 0;
            while(k < wordList.get(i).length()) {
                if(beginWord.charAt(k) != wordList.get(i).charAt(k)){
                    x++;
                }
                k++;
            }
            if(x == 1) {
                queue.add(wordList.get(i));
            }

        }

    }
}