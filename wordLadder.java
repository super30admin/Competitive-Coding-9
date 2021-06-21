import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(m*m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> sSet=new HashSet<>(wordList);// O(n)
        Queue<String> queue=new LinkedList<>();  // O(n)
        int count=1;
        
        queue.add(beginWord);
        
        
        while(!queue.isEmpty()){ //O(n)
            
            int size=queue.size();
            
            for(int i=0;i<size;i++){ //O(m
                String temp=queue.remove();
                
                char[] charArr=temp.toCharArray();
                for(int j=0;j<charArr.length;j++){ // O(m)
                    char current=charArr[j];
                    for( char c='a'; c<='z';c++){ // O(26)
                        charArr[j]=c;
                        String presentWord=new String(charArr);
                        if(sSet.contains(presentWord)){
                            if(presentWord.equals(endWord)){
                                return count+1;
                            }
                            queue.add(presentWord);
                            sSet.remove(presentWord);
                        }
                    }
                    charArr[j]=current;
                }
            }
            count++;
            
        }
        
        return 0;    
    }
}