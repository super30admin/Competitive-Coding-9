class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        # the tickets to take depend on the future day as well to get the mim cost as possible
        # and since we cannot tell taking one day pass will give best deal or not we have to exhaustively check all the 3 possibilty passes, keep track of them to see which pass can give best
        # using dp # tc : O(3n*2), 3 passes check for each of the n days, but checking in a list also takes O(n) total O(3n*2) but since days are bounded to 1-365 its constant time O(1)
        # sc : O(2n) hashmap and recrussive stack space 


        self.days = days
        self.costs = costs
        self.memo = {} # saving the min cost taken form this travel day so that we dont recompute them again
        self.last_day = days[-1] 

        self.dp(days[0]) # recurssively search until we got the min cost 

        return self.memo[days[0]] 

    def dp(self,travel_day):
        if travel_day > self.last_day: # once we have reached till the last day we covered all the days and we can stop 
            return 0

        if travel_day not in self.days:
            return self.dp(travel_day+1) # since we don't know whats the next travel day , lets check if its there if not then skip that day as we won't travl and no need to add cost

        if travel_day in self.memo: # 
            return self.memo[travel_day]
        else :
            self.memo[travel_day] = min( # the cost will be min of the passes util this day and the cost after the pass coverage day
                self.costs[0] + self.dp(travel_day+1), 
                self.costs[1] + self.dp(travel_day+7),
                self.costs[2] + self.dp(travel_day+30)
            )
        
        return self.memo[travel_day]
