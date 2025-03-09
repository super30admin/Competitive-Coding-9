// TC => O(n) number of matching words found in dictionary
// SC => O(n)

public class Solution {
    HashSet<string> hashset;
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {
        if(beginWord == null || beginWord.Length == 0 || endWord == null || endWord.Length == 0){
            return 0;
        }

        Queue<string> queue = new Queue<string>();
        hashset = new HashSet<string>(wordList);

        int counter = 0;

        queue.Enqueue(beginWord);
        while(queue.Count > 0){
            int size = queue.Count();
            counter++;
            for(int i = 0; i< size; i++){
                var word = queue.Dequeue();

                if(word == endWord){
                    return counter;
                }

                var list = GetNewWord(word);
                foreach(var w in list){
                    queue.Enqueue(w);
                }
            }
        }
        return 0;

    }

    public List<string> GetNewWord(string word){
        List<string> result = new List<string>();

        char[] newArray = word.ToCharArray();
        for(int i = 0; i < word.Length; i++){
            for(char j = 'a'; j <= 'z';j++){
                var temp = newArray[i];
                newArray[i] = j;
                var newWord = new string(newArray);
                if(hashset.Contains(newWord)){
                    hashset.Remove(newWord);
                    result.Add(newWord);
                }
                newArray[i] = temp;
            }
        }
        return result;
    }
}