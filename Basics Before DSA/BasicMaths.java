public class BasicMaths {
    public static void main(String[] args){
        System.out.println("No. of Digits in 3453 are "+countDigit(3453));
    }
    public static int countDigit(int num){
        int count = 0;
        while(num!=0){
            num/=10;
            count++;
        }
        return count;
    }
}
