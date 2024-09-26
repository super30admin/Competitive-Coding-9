// Problem 1 - Minimum Cost For Tickets
// Time Complexity : O(n) where n = last day number + 1
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    if (days.length == 0) {
      return 0;
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i=0; i<days.length; i++) {
      set.add(days[i]);
    }

    int[] dp = new int[days[days.length - 1] + 1];
    for (int i=1; i<dp.length; i++) {
      if (!set.contains(i)) {
        dp[i] = dp[i - 1];
      } else {
        dp[i] = Math.min(
          dp[i - 1] + costs[0], Math.min(
            dp[Math.max(i - 7, 0)] + costs[1],
            dp[Math.max(i - 30, 0)] + costs[2]
          ));
      }
    }

    return dp[dp.length - 1];
  }
}

// Problem 2 - Word Ladder
// Time Complexity : O(k * n) where k = length of word, n = length of wordList
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  Queue<String> queue;
  private int count = 1;

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    queue = new LinkedList<>();
    queue.add(beginWord);

    while (!queue.isEmpty()) {
      int size = queue.size();
      count++;

      for (int i=0; i<size; i++) {
        String word = queue.poll();
        findWord(word, wordList);
        if (queue.contains(endWord)) {
          return count;
        }
      }
    }

    return 0;
  }

  private void findWord(String word, List<String> wordList) {
    List<String> list = new ArrayList<>();
    for (String str : wordList) {
      int k = 0;
      for (int i=0; i<str.length(); i++) {
        if (str.charAt(i) != word.charAt(i)) {
          k++;
        } else {
          if (k > 1) {
            break;
          }
        }
      }

      if (k == 1) {
        list.add(str);
        queue.add(str);
      }
    }

    wordList.removeAll(list);
  }
}
