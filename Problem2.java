class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = -1;
        for(int day:days)
            max = Math.max(max, day);

        int []res = new int[max+1];
        int index = 0;
        for(int i=days[0];i<=max;i++){
            if(i!=days[index]){
                res[i] = res[i-1];
                continue;
            }

            res[i] = min(res[Math.max(i-1,0)]+costs[0], res[Math.max(i-7,0)]+costs[1], res[Math.max(i-30,0)]+costs[2]);
            index++;
        }
        return res[max];
    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}