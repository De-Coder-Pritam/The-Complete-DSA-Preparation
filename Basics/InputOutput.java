import java.util.Scanner;

class InputOutput{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        printNumber(sc);
        sc.close();

    }
    public static void printNumber(Scanner sc){
        int num = sc.nextInt();
        System.out.println(num);
    }
}