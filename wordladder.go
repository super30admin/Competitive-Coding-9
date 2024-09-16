// Time Complexity : O(nm)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a map of each pattern for each word in the list replacing current letter with *
in a q of pairs begin with beginword and currVal as 1
while q is not empty pop and check for each letter if a word is present for that pattern that is not already visited
if not visited then put it in queue and if it matches endword then return that currval+1
*/
package main

import "fmt"

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if len(beginWord) == 0 || len(endWord) == 0 || len(wordList) == 0 || len(beginWord) != len(endWord) {
		return 0
	}
	flag := true
	for i := 0; i < len(wordList); i++ {
		if endWord == wordList[i] {
			flag = false
		}
	}
	if flag {
		return 0
	}

	m := make(map[string][]string, 0)

	for _, word := range wordList {
		for i := 0; i < len(word); i++ {
			pattern := word[:i] + "*" + word[i+1:]
			val, ok := m[pattern]
			if ok {
				m[pattern] = append(val, word)
			} else {
				m[pattern] = []string{word}
			}
		}
	}

	visited := make(map[string]bool, 0)
	visited[beginWord] = true
	temp := Constructor(beginWord, 1)
	q := []*Pairs{&temp}

	for len(q) > 0 {
		curr := q[0]
		q = q[1:]
		currWord := (*curr).Word
		currVal := (*curr).Val

		for i := 0; i < len(currWord); i++ {
			currPattern := currWord[:i] + "*" + currWord[i+1:]
			currList, exists := m[currPattern]
			if exists {
				for _, currListVal := range currList {
					if currListVal == endWord {
						return currVal + 1
					}
					_, vi := visited[currListVal]
					if !vi {
						visited[currListVal] = true
						temp2 := Constructor(currListVal, currVal+1)
						q = append(q, &temp2)
					}
				}
			}
		}
	}
	return 0
}

type Pairs struct {
	Word string
	Val  int
}

func Constructor(w string, v int) Pairs {
	return Pairs{
		Word: w,
		Val:  v,
	}
}

func MainWordLadder() {
	fmt.Println(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log", "cog"})) //expected 5
}
