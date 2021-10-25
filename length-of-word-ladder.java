//Time complexity: O(M^2 * N)
//Space complexity: O(M^2 * N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word: wordList) {
            set.add(word);
        }
        //if the set does not contain the end word
        if(!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        int level=1;

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int itr = 0; itr < size; itr++){
                String curr = queue.poll();
                char[] str = curr.toCharArray();
                
                if(curr.equals(endWord)){
                    return level;
                }

                for(int idx = 0; idx < str.length; idx++){
                    char c = str[idx];
                    
                    for(char letter = 'a'; letter <= 'z'; letter++){
                        if(str[idx] != letter){
                            str[idx] = letter;
                            String newStr = new String(str);

                            if(set.contains(newStr)){
                                queue.add(newStr);
                                set.remove(newStr);
                            }

                            str[idx] = c;
                        }
                    }
                }
            }
            
            level++;
        }
        return 0;

    }
}