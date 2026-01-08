import java.util.ArrayList;
import java.util.List;

public class BasicMaths {
    public static void main(String[] args){
//        System.out.println("No. of Digits in 3453 are "+countDigit(3453));
//        System.out.println("Reverse of -123 is "+reverseNumber(-123));
//        System.out.println("Reverse of 1224 is "+reverseNumber(1224));
//        System.out.println("Reverse of 1534236469 is "+reverseNumber(1534236469));
//        System.out.println("Reverse of -1534236469 is "+reverseNumber(-1534236469));
//
//        System.out.println("Reverse of -123 is "+reverseAlternate(-123));
//        System.out.println("Reverse of 1224 is "+reverseAlternate(1224));
//        System.out.println("Reverse of 1534236469 is "+reverseAlternate(1534236469));
//        System.out.println("Reverse of -1534236469 is "+reverseAlternate(-1534236469));
//        System.out.println("is 122 a palindrome number: "+isPalindrome(122));
//        System.out.println("GCD of 12 and 24 is: "+GCD(12,24));
//        System.out.println("is 0 a armstrong number: "+isArmstrong(0));
//        System.out.println("is 153 a armstrong number: "+isArmstrong(153));
//        System.out.println("is 9474 a armstrong number: "+isArmstrong(9474));
//        System.out.println("is 9475 a armstrong number: "+isArmstrong(9475));
//printArray(divisors(7));
        System.out.println(getDivisors(7));
        System.out.println(getDivisors(36));
        System.out.println("is 1 a prime number: "+isPrime(1));
        System.out.println("is 123 a prime number: "+isPrime(123));
        System.out.println("is 10 a prime number: "+isPrime(10));
        System.out.println("is 5 a prime number: "+isPrime(5));



    }
    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    public static List<Integer> getDivisors(int num){
        List<Integer> divisors = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                divisors.add(i);
                if(i != num/i){
                    divisors.add(num/i);
                }
            }
        }
        return divisors;
    }
    public static void printArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static int[] divisors(int num){
        int[] divisors = new int[(int)Math.sqrt(num)+1];
        int count=0;
        for(int i=1;i<=num;i++){
            if(num%i==0){
                divisors[count++]=i;
            }
        }
        return divisors;
    }
    public static boolean isArmstrong(int num){
        int count = countDigit(num);
        int n = num;
        int sum = 0;
        while(n!=0){
            int dig = n%10;
            sum += (int)Math.pow(dig,count);
            n/=10;
        }
        return sum == num;

    }
    public static int GCD(int n1,int n2){
        int gcd = Math.min(n1,n2);
        while(n1%gcd != 0 || n2%gcd != 0)
            gcd--;
        return gcd;
    }

    public static int countDigit(int num){
        int count = 0;
        while(num!=0){
            num/=10;
            count++;
        }
        return count;
    }
    public static int reverseAlternate(int num){
        int rev=0;
        boolean neg = false;
        if(num<0){
            num *= -1;
            neg = true;
        }
        while(num!=0){
            int dig=num%10;
            System.out.print(dig+" ");
            if(dig!=0){
                if((Integer.MAX_VALUE-dig)/10 <rev){
                    return 0;
                }
            }
            rev = rev*10+dig;
            num/=10;
        }
        if(neg){
            return rev*-1;
        }else{
            return rev;
        }
    }
    public static int reverseNumber(int num){
        int rev=0;
        while(num!=0){
            int dig = num%10;
            if(dig < 0) {
                if ((Integer.MIN_VALUE + (dig*-1))/ 10 > rev)
                    return 0;
            }else if(dig>0){
                if((Integer.MAX_VALUE - dig)/10 < rev){
                    return 0;
                }
            }
            rev = rev*10 + dig;
            num/=10;
        }
        return rev;
    }

    public static boolean isPalindrome(int n){
        int num = n;
        int rev=0;
        while(n!=0){
            int dig=n%10;
            rev=rev*10+dig;
            n/=10;
        }
        return rev==num;
    }
}
