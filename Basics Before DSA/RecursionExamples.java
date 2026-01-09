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

        System.out.println("factorial of 6: "+factorial(6));
        System.out.println("factorial of 4: "+factorial(4));
        System.out.println("--------------***************--------------");
        System.out.println("--------------***************--------------");
        System.out.println("factorial of 6: "+factorialRecursion(6));
        System.out.println("factorial of 4: "+factorialRecursion(4));
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
