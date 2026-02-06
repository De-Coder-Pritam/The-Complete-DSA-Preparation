import java.util.Scanner;

public class ArrayOperations {
    public static void main(String... args) throws InterruptedException{
        int []arr = new int[50];
        Scanner sc = new Scanner(System.in);
        int end=0;
        int num;
        arr[end++]=21;
        arr[end++]=34;
        arr[end++]=45;
        arr[end++]=12;
        printArray(arr,end);
        int option = printDetails(sc);
        while(option != 0 && end < arr.length){
            switch(option){
                case 3:
                    insert_at_end(arr,end++,sc);
                    printArray(arr,end);
                    option = printDetails(sc);
                    break;
                default:



            }
        }


    }
    public static void insert_at_middle(int[] num, Scanner sc){
        System.out.print("\nEnter the Position: ");
    }

    public static void printArray(int[] arr,int end){
        System.out.print("Array Elements are: ");
        for(int i=0;i<end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
    public static void insert_at_end(int[] arr,int end,Scanner sc){
        System.out.print("Enter the Value: ");
        int val = sc.nextInt();
        arr[end]=val;
    }
    public static int printDetails(Scanner sc){
        System.out.println("Choose the Operation you want to Perform: ");
        System.out.println("Press 1 to insert at the Beginning (1)");
        System.out.println("Press 2 to insert at the middle (2)");
        System.out.println("Press 3 to insert at the End (3)");
        System.out.println("Press 0 to Quit (0)");
        System.out.print("\nEnter Your Option: ");
        int num = sc.nextInt();
        return num;

    }
}
