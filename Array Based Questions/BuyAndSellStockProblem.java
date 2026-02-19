public class BuyAndSellStockProblem {
/*
Example 1

    Input: arr = [10, 7, 5, 8, 11, 9]

    Output: 6

    Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.

    Example 2

    Input: arr = [5, 4, 3, 2, 1]

    Output: 0

    Explanation: In this case, no transactions are made. Therefore, the maximum profit remains 0.
 */
    public static void main(String[] args){
        int[] arr = {10, 7, 5, 8, 11, 9};
        System.out.println(stockBuySellOptimal(arr));
    }
    public static int stockBuySellOptimal(int[] arr){
        int min=arr[0];
        int maxProfit=0;
        int profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=min){
                profit=arr[i]-min;
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }else{
                min = arr[i];
            }
        }
        return maxProfit;
    }
    public static int stockBuySellBrute(int[] arr) {
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){

            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int pr = arr[j]-arr[i];
                    if(maxProfit < pr){
                        maxProfit = pr;
                    }
                }
            }
        }
        return maxProfit;
    }
}
