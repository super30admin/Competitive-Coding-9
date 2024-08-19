# Competitive-Coding-9

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 



### Question 1 

https://leetcode.com/problems/minimum-cost-for-tickets/description/

In this approach first we are storing all the days we are travelling in HashSet for O(1) search. Then we are taking a maximum day from days array and creating a dp array of maximum days + 1 length. Now to fill this array we are calculating best possible cost on that day by taking minimum of total cost of using 1 day pass 7 days pass and 30 days pass. If we are not traveling that day we are just simply taking value as it is from previous. At the end we are returning the cost of the last day as it will be a optimized cost.



### Question 2

https://leetcode.com/problems/word-ladder/description/

In this solution we are using Breadth-First Search to explore the shortest transformation sequence from BeginWord to endWord. We will generate all possible intermediate words by replacing each letter with wildcard character, and then we will map these intermediate forms to the corresponding words in the wordList. BFS will ensure that the first time endWord is encountered and this is how we have found the shortest path.