import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(m *n); where n is total number of words and m is avg length of a word
//Space Complexity : O(n)
public class WordLadder {	
	/**Approach: BFS**/
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet= new HashSet<>(wordList);
        Queue<String> q= new LinkedList<>();
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0; i<size; i++){ //O(n)
                char[] curr= q.poll().toCharArray();
                //find neighbours and see if endword found                
                for(int j=0; j<curr.length; j++){ //O(m)
                    char temp= curr[j];
                    //Transform the word by each character
                    for(char c='a'; c<='z'; c++){ //O(26)=> O(1)
                        curr[j]= c;
                        String neigh= new String(curr);                       
                        if(wordSet.contains(neigh)){
                            //System.out.println(neigh+ " level "+ level);
                            if(endWord.equals(neigh)) return level+1;
                            q.add(neigh);
                            wordSet.remove(neigh);
                        }
                    }                    
                    //reset the char for further transformation
                    curr[j]= temp;
                }
            }
            level++;
        }
        return 0;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		WordLadder ob= new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.print("Number of words in the shortest transformation sequence are: "+ob.ladderLength(beginWord, endWord, wordList));			
	}
}
