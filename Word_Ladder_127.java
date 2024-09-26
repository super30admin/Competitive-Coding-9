//Time Complexity : O(n^2) // O(26 * n^2)
//Space Complexity : O(n)  // n : number of words present in the wordList
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Word_Ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth = 0;
        while(!q.isEmpty()){
            depth += 1;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                for(int j = 0; j < curr.length(); j++){
                    char[] temp = curr.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        if(temp[j] == c)
                            continue;
                        temp[j] = c;
                        String tempo = String.valueOf(temp);
                        if(tempo.equals(endWord))
                            return depth+1;
                        if(set.contains(tempo)){
                            q.add(tempo);
                            set.remove(tempo);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
    	List<String> list = new ArrayList<>();
    	list.add("hot");
    	list.add("dot");
    	list.add("dog");
    	list.add("lot");
    	list.add("log");
    	list.add("cog");
    	
    	Word_Ladder_127 wLadder = new Word_Ladder_127();
    	System.out.println(wLadder.ladderLength("hit", "cog", list));
    }
}
