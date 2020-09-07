import java.util.*;

//Time complexity: O((m*n)^2), m is number of words and n is length of the word
//Space complexity: O((m*n)^2) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : no

class pair{
	String word;
	int len;
	pair(String word, int len){
		this.word = word;
		this.len = len;
	}
}
class Word_ladder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {    
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(beginWord, 1));
		while(!q.isEmpty()){
			pair curr = q.poll();
			ListIterator<String> itr = wordList.listIterator();
			while(itr.hasNext()){
				String temp = itr.next();
				if(isAdjacency(curr.word, temp)){
					itr.remove();
					q.add(new pair(temp, curr.len +1));

					if(temp.equals(endWord))
						return curr.len + 1;
				}
			}   
		}
		return 0;
	}
	private boolean isAdjacency(String s1, String s2){
		int count = 0;
		for(int i=0; i<s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				count++;
			}
			if(count > 1)
				return false; 
		}
		return count>1 ? false : true;
	}
}