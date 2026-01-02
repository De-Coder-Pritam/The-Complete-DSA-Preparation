public class PatternEx {
    public static void main(String... args){
//        patternOne(5);
//        patternTwo(5);
//        patternThree(5);
//        patternFour(5);
//        patternFive(5);
        patternSix(5);
    }
    public static void patternSeven(int num){
        for(int i=1;i<=num;i++){
            for(int j=)
        }
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i*2-1;j++){
                System.out.print("*")
            }
        }
    }
    public static void patternSix(int num){
        for(int i=num;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void patternFive(int num){
        for(int i=num;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void patternFour(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void patternThree(int num){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void patternTwo(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void patternOne(int num){
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
