public class RecursionExamples {
    public static void main(String[] args){
//        printNumbersReverse(5);
//        System.out.println("--------------***************--------------");
//        printNumbersReverse(-4);
//        System.out.println("Sum of first 6 numbers: "+NnumbersSum(6));
//        System.out.println("--------------***************--------------");
//        System.out.println("Sum of first 4 numbers: "+NnumbersSum(4));
//        System.out.println("--------------***************--------------");
//        System.out.println("--------------***************--------------");
//        System.out.println("Sum of first 6 numbers: "+NnumbersSumRecursion(6));
//        System.out.println("--------------***************--------------");
//        System.out.println("Sum of first 4 numbers: "+NnumbersSumRecursion(4));
//
//        System.out.println("factorial of 6: "+factorial(6));
//        System.out.println("factorial of 4: "+factorial(4));
//        System.out.println("--------------***************--------------");
//        System.out.println("--------------***************--------------");
//        System.out.println("factorial of 6: "+factorialRecursion(6));
//        System.out.println("factorial of 4: "+factorialRecursion(4));
//        int[] arr = {67,56,45,35,89,21};
//        printArray(arr);
//        reverseArray(arr,arr.length);
//        printArray(arr);
//        System.out.println("fibonacci of 2nd term: "+fibNumberRecursion(2));
//        System.out.println("--------------***************--------------");
//        System.out.println("fibonacci of 3rd term: "+fibNumberRecursion(3));
//        System.out.println("--------------***************--------------");
//        System.out.println("fibonacci of 4th term: "+fibNumberRecursion(4));
//        System.out.println("fibonacci of 2nd term: "+fibNumber(2));
//        System.out.println("--------------***************--------------");
//        System.out.println("fibonacci of 3rd term: "+fibNumber(3));
//        System.out.println("--------------***************--------------");
//        System.out.println("fibonacci of 4th term: "+fibNumber(4));
        System.out.println("hannah is palindrome : "+palindromeCheck("hannah"));
        System.out.println("--------------***************--------------");
        System.out.println("pritam is palindrome : "+palindromeCheck("pritam"));
        System.out.println("--------------***************--------------");
        System.out.println("aabbaaa is palindrome : "+palindromeCheck("aabbaaa"));
        System.out.println("--------------***************--------------");
    }
    public static boolean palindromeCheck(String str){
        if(str.length()<=1){
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length()-1)){
            System.out.println(str);
            return palindromeCheck(str.substring(1,str.length()-1));
        }else{
            return false;
        }

    }
    public static int fibNumber(int num){
        int first=0;
        int second=1;
        if(num==0)
            return 0;
        if(num==1)
            return 1;
        int cnt = first+second;
        for(int i=3;i<=num;i++){
            first=second;
            second=cnt;
            cnt=first+second;
        }
        return cnt;
    }
    public static int fibNumberRecursion(int num){
        if(num<=1){
            return 0;
        }else if(num==2){
            return 1;
        }
        return fibNumber(num-1)+fibNumber(num-2);
    }
    public static void printArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println("\n------------*************--------------");
    }

    public static void reverseArray(int[] arr, int num){
        if(num<=arr.length/2){
            return;
        }
        int temp = arr[num-1];
        arr[num-1]=arr[arr.length-num];
        arr[arr.length-num] = temp;
        reverseArray(arr,num-1);
    }

    public static int factorialRecursion(int num){
        if(num<=1){
            return num;
        }
        return num * factorialRecursion(num-1);
    }
    public static int factorial(int num){
        int fact = 1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }
    public static int NnumbersSum(int num){
        return num * (num+1)/2;
    }
    public static int NnumbersSumRecursion(int num){
        if(num<=1){
            return 1;
        }
        return num + NnumbersSumRecursion(num-1);
    }
    public static void printNumbers(int num){
        if(num<=1){
            System.out.println(num);
            return;
        }
        printNumbers(num-1);
        System.out.println(num);
    }
    public static void printNumbersReverse(int num){
        if(num<=1){
            System.out.println(num);
            return;
        }
        System.out.println(num);
        printNumbersReverse(num-1);
    }
}
