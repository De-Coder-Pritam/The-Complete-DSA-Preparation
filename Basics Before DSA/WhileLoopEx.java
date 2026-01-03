public class WhileLoopEx {
    public static void main(String... args){
        int i=1;
        while(i<10){
            System.out.println(i++);
        }
        do{
            System.out.println(i--);
        }while(i>=1);
    }
}
