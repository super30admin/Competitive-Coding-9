class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        unordered_set<int>s;
        for(int i=0;i<days.size();i++)
            s.insert(days[i]);
        int maxi=days[days.size()-1];
        int A[maxi+1];
        A[0]=0;
        for(int i=1;i<(maxi+1);i++)
        {
            if(!s.count(i))
            {
                A[i]=A[i-1];
            }
            else
            {
                int max1=max(0,i-7);
                int max2=max(0,i-30);
                int min1=min(A[max1]+costs[1],A[max2]+costs[2]);
                A[i]=min(A[i-1]+costs[0],min1);
            }
        }
        return A[maxi];
    }
};