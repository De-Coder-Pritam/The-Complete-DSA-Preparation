public class FindSquareRootOfNumberProblem {
    /*
    Given a positive integer n. Find and return its square root.
    If n is not a perfect square, then return the floor value of sqrt(n).
    Example 1
    Input: n = 36
    Output: 6
    Explanation: 6 is the square root of 36.
    Example 2
    Input: n = 28
    Output: 5
    Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.
     */
    public static void main(String[] args){
        int num1 = 36, num2=28;
        System.out.println(floorSqrtOptimal(num1));
        System.out.println(floorSqrtOptimal(num2));
    }
    public static int floorSqrtOptimal(int n){
        int low =1,high=n,ans = 1;
        while(low<=high){
            long mid = low+(high-low)/2;
            if((mid*mid) <= n){
                ans = (int) mid;
                low = (int)mid+1;
            }else{
                high = (int)mid-1;
            }
        }
        return ans;
    }
    public static int floorSqrtBrute(int n) {
        int ans=1;
        for(int i=1;i<=n;i++){
            if(i*i<=n){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }
}
