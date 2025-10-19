// Time Complexity - O(N * (L*L)), N is length of words and L is average length of words
// Space Complexity - O(N*L)
function ladderLength(
	beginWord: string,
	endWord: string,
	wordList: string[]
): number {
	const wordSet = new Set(wordList);
	if (!wordSet.has(endWord) || beginWord === endWord) {
		return 0;
	}

	const A_CHAR_CODE = "a".charCodeAt(0);
	const Z_CHAR_CODE = "z".charCodeAt(0);
	const visited = new Set<string>([beginWord]);

	let q = [beginWord];
	let depth = 1;

	while (q.length > 0) {
		// get the current level length to process only words from this depth
		let levelSize = q.length;

		for (let k = 0; k < levelSize; k++) {
			const currentWord = q.shift()!;
			const charArr = currentWord.split("");

			// iterate through each character in charArr
			for (let i = 0; i < charArr.length; i++) {
				const originalChar = charArr[i];

				// check which character in current word can be replaced which has a valid word in the wordSet
				// check all possible word by replacing index "i" in charArr to see if we have a valid next word in the wordList
				for (let j = A_CHAR_CODE; j <= Z_CHAR_CODE; j++) {
					const newChar = String.fromCharCode(j);

					if (newChar !== originalChar) {
						// replace current char
						charArr[i] = newChar;
						const nextWord = charArr.join("");

						// return early if target is found
						if (nextWord === endWord) {
							return depth + 1;
						}

						// check if the possible nextWord is valid and not visited
						if (wordSet.has(nextWord) && !visited.has(nextWord)) {
							q.push(nextWord);
							visited.add(nextWord);
						}
					}
				}

				// reset original character to ensure the word is correct for the next position
				charArr[i] = originalChar;
			}
		}

		// update depth after current level is processed
		depth++;
	}

	return 0;
}
