TC - O(N)
SC -  O(1)
/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
  var dp = new Array(days[days.length-1]+1).fill(0);
    dp[0]=0;
    for(let i=1;i<dp.length;i++)
    {
        if(!days.includes(i))
        {
            dp[i]=dp[i-1];
        }
        else
        {
            dp[i]=Math.min(dp[Math.max(0,i-1)]+costs[0],
              dp[Math.max(0,i-7)]+costs[1],
              dp[Math.max(0,i-30)]+costs[2])
        }
    }
    return dp[dp.length-1];  
};