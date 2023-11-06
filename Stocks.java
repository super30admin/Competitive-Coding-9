class Stocks {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min=Integer.MAX_VALUE;
        for(int x=0;x<prices.length;x++){
            if(prices[x]<min){
                min=prices[x];
            }else if(prices[x]-min>0){
                profit+=prices[x]-min;
                min=Integer.MAX_VALUE;
                x--;
            }
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        Stocks obj = new Stocks();
        System.out.println(obj.maxProfit(prices));
    }
}