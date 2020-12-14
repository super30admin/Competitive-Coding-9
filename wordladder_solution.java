package Stringscodes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordladder_solution {
public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);
        
        if(!words.contains(endWord)) {
        	return 0;
        }
        
        Queue<String> queue= new LinkedList<>();
        
        queue.offer(beginWord);
        
        int level=1;
        
        
        while(!queue.isEmpty()) {
        	
        	int size=queue.size();
        	
        	for(int i=0;i<size;i++) {
        		String current_word=queue.poll();
        		char [] word_chars =current_word.toCharArray();
        		for(int j=0;j<word_chars.length;j++) {
        			
        			char original_char=word_chars[j];
        			
        			for(char c='a';c<'z';c++) {
        				if(original_char==c) continue;
        				word_chars[j]=c;
        				String new_word=String.valueOf(word_chars);
        				
        				if(new_word==endWord) return level+1;
        				if(words.contains(new_word)) {
        					queue.offer(new_word);
        					words.remove(new_word);
        					
        				}
        			}
        			
        			word_chars[j]=original_char;
        			
        		}
        		
        		
        		level++;
        		
        		
        	}
        	
        	
        	
        	
        }
        
        
        
        
    }
}
