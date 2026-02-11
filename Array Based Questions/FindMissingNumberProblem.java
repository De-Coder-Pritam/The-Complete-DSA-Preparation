public class FindMissingNumberProblem {
    public static void main(String... args){
        int[] nums = {0, 1, 2, 4, 5, 6};
        System.out.println("Difference is: "+missingNumberBetter(nums));
    }
    public static int missingNumberOptimal2(int[] arr){
        int xor1=0,xor2=0,n=arr.length;
        for(int i=0;i<arr.length;i++){
            xor1 ^= arr[i];
        }
        for(int i=0;i<=n;i++){
            xor2 ^= i;
        }
        return xor2 ^ xor1;
    }
    public static int missingNumberBetter(int[] arr){
        int[] hash = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberOptimal3(int[] arr){
        int arrSum = 0;
        int actualSum = 0;
        for(int i=0;i<arr.length;i++){
            arrSum += arr[i];
            actualSum += i+1;
        }
        return actualSum-arrSum;
    }
    public static int missingNumberOptimal1(int[] arr){
        int n = arr.length;
        int original = n * (n+1)/2;
        int arrSum = 0;
        for(int i=0;i<n;i++){
            arrSum+=arr[i];
        }
        return original-arrSum;
    }
    public static int missingNumberBrute(int[] arr){
        for(int i=0;i<=arr.length;i++){
            boolean found = false;
            for(int j=0;j<arr.length;j++){
                if(arr[j] == i)
                    found = true;
            }
            if(!found){
                return i;
            }
        }
        return -1;
    }
}
