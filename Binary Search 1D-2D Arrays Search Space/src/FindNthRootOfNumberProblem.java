public class FindNthRootOfNumberProblem {
    /*
    Given two numbers N and M, find the Nth root of M.
    The Nth root of a number M is defined as a number X such that
    when X is raised to the power of N, it equals M.
    If the Nth root is not an integer, return -1.
    Example 1
    Input: N = 3, M = 27
    Output: 3
    Explanation: The cube root of 27 is equal to 3.
    Example 2
    Input: N = 4, M = 69
    Output:-1
    Explanation: The 4th root of 69 does not exist. So, the answer is -1.
     */
    public static void main(String[] args){
        System.out.println(nthRootBrute(3,27));
        System.out.println(nthRootBrute(4,69));
        System.out.println(nthRootOptimal(3,27));
        System.out.println(nthRootOptimal(4,69));
    }
    public static int nthRootBrute(int n, int m){
        for(int i=1;i<=m;i++){
            int num = (int)Math.pow(i,n);
            if(num == m) return i;
            else if(num > m) break;
        }
        return -1;
    }
    public static int nthRootOptimal(int n, int m){
        int low=1,high=m;
        while(low<=high){
            int mid = low + (high-low)/2;
            int ans = 1;
            for(int i=1;i<=n;i++){
                ans *= mid;
                if(ans > m) break;
            }

            if(ans == m) return mid;
            else if(ans > m) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
