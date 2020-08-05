/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
    let dp = new Array(days[days.length-1]+1).fill(0);
    let b;
    let c;
    for(let i = 1; i<dp.length; i++){
        if( days.includes(i)){
            //1 day
            let a = dp[i-1] + costs[0];
            //7 day
            if(i < 7){
                 b = costs[1];
            } else {
                b = dp[i-7] + costs[1];
            }
           if(i < 30){
                 c = costs[2];
            } else {
                c = dp[i-30] + costs[2];
            }

                dp[i] = Math.min(a,Math.min(b,c));

        } else {
            dp[i] = dp[i-1];
        }
    }
    
    return dp.pop();
    
};

//time complexity : O(n2)