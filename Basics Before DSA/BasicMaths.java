public class BasicMaths {
    public static void main(String[] args){
        System.out.println("No. of Digits in 3453 are "+countDigit(3453));
        System.out.println("Reverse of -123 is "+reverseNumber(-123));
        System.out.println("Reverse of 1224 is "+reverseNumber(1224));
        System.out.println("Reverse of 1534236469 is "+reverseNumber(1534236469));
        System.out.println("Reverse of -1534236469 is "+reverseNumber(-1534236469));

        System.out.println("Reverse of -123 is "+reverseAlternate(-123));
        System.out.println("Reverse of 1224 is "+reverseAlternate(1224));
        System.out.println("Reverse of 1534236469 is "+reverseAlternate(1534236469));
        System.out.println("Reverse of -1534236469 is "+reverseAlternate(-1534236469));
        System.out.println("is 122 a palindrome number: "+isPalindrome(122));
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
