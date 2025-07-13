// 127. Word Ladder
var ladderLength = function(beginWord, endWord, wordList) {

    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return 0;

    let front = new Set([beginWord]);
    let back = new Set([endWord]);

    const letters = ['a','b','c','d','e','f','g','h','i','j','k','l','m',
                     'n','o','p','q','r','s','t','u','v','w','x','y','z'];
    let mutations = 1;

    while (front.size && back.size) {

        if (front.size > back.size) [front, back] = [back, front];

        const nextFront = new Set();

        for (const word of front) {
            const wordArr = word.split('');

            for (let i = 0; i < wordArr.length; i++) {
                const oldChar = wordArr[i];

                for (const g of letters) {
                    if (g === oldChar) continue;

                    wordArr[i] = g;
                    const newWord = wordArr.join('');

                    if (back.has(newWord)) return mutations + 1;

                    if (wordSet.has(newWord)) {
                        nextFront.add(newWord);
                        wordSet.delete(newWord);
                    }
                }

                wordArr[i] = oldChar;
            }
        }

        front = nextFront;
        mutations++;
    }

    return 0;
};