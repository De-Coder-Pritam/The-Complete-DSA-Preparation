import java.util.Scanner;
public class IfElse {
    public static void main(String ... ars){
        Scanner sc = new Scanner(System.in);
        printGrade(sc);
        sc.close();
    }
    public static void printGrade(Scanner sc){
        int num = sc.nextInt();
        if(num>=90){
            System.out.println("Grade A");
        }else if(num >=70){
            System.out.println("Grade B");
        }else if(num>=50){
            System.out.println("Grade C");
        }else if(num >=35){
            System.out.println("Grade D");
        }else{
            System.out.println("Fail");
        }
    }
}
