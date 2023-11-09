// Time Complexity : O(n*k) where n is the size of wordList and k is the length of beginWord
// Space Complexity : O(n) in worst case all elements in wordList will go together in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0){
            return 0;
        }

        HashSet<String> set = new HashSet<>();

        for(String s : wordList){
            set.add(s);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return level;
                }
                for(int i = 0; i < word.length(); i++){
                    char[] arr = word.toCharArray();
                    char ch = 'a';
                    for(int j = 0; j < 26; j++){
                        arr[i] = (char)(ch + j);
                        String changeWord = String.valueOf(arr);
                        if(set.contains(changeWord)){
                            q.add(changeWord);
                            set.remove(changeWord);
                        }
                    }
                    arr[i] = word.charAt(i);
                }
            }
            level++;
        }

        return 0;
    }
}
