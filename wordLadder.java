package CompetitiveCoding9;
//Time Complexity :O(m^2*n) where n = number of words and m = length of the word
//Space Complexity : O(m*n) 
public class wordLadder {
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        
	        HashSet<String> set = new HashSet<>();
	        for(String word : wordList){
	            set.add(word);
	        }
	        
	        if(!set.contains(endWord)) return 0;
	        
	        Queue<String> q = new LinkedList<>();
	        q.offer(beginWord);
	        int level = 1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0; i<size; i++){
	                String curr = q.poll();
	                char[] charWord = curr.toCharArray();
	                for(int j=0; j<charWord.length; j++){
	                    char temp = charWord[j];
	                    for(char c='a';c<'z';c++){
	                        if(charWord[j] == c) continue;
	                            charWord[j] = c;
	                        String newStr = String.valueOf(charWord);
	                        if(newStr.equals(endWord)) return level+1;
	                        if(set.contains(newStr)){
	                            q.offer(newStr);
	                            set.remove(newStr);
	                        }
	                    }
	                    charWord[j] = temp;
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	}
}
