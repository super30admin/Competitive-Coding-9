TC - O(M^2*N)
SC-  O(M^2*N)

var ladderLength = function(beginWord, endWord, wordList) {
    let setOfWordList = new Set(wordList);
    let queue = [beginWord];
    let level = 1;

    while(queue.length > 0) {
        let nextState = [];
    
        for(let word of queue) {
            if(word === endWord) return level;
        
            for (let char = 0; char < word.length; char++) {
                for(let currentAlphabet = 0; currentAlphabet < 26; currentAlphabet++) {
                    let newWord = word.slice(0, char) + String.fromCharCode(currentAlphabet + 97) + word.slice(char + 1);
                
                    if(setOfWordList.has(newWord)) {
                        nextState.push(newWord);
                        setOfWordList.delete(newWord);
                    }
                }
            }
        }
        queue = nextState;
        level++;
    }
    return 0;
};