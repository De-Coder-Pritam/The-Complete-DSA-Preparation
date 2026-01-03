public class PatternEx {
    public static void main(String... args){
//        patternOne(5);
//        patternTwo(5);
//        patternThree(5);
//        patternFour(5);
//        patternFive(5);
//        patternSix(5);
//        patternSeven(5);
//        patternEight(5);
//        patternNine(5);
//        patternTen(5);
//        patternTenAlternate(5);
//        patternEleven(5);
//        patternTwelve(4);
//        patternThirteen(5);
//        patternFourteen(5);
//        patternFifteen(5);
//        patternSixteen(5);
//        patternSeventeen(4);
//        patternEighteen(7);
//        patternNineteen(5);
//        patternTwentyOne(4);
        patternTwentyTwo(4);
    }
    public static void patternTwentyTwo(int num){
        for(int i=1;i<=num*2-1;i++){
            for(int j=1;j<=num*2-1;j++){
                int top = i;
                int bottom = (2*num)-i;
                int left = j;
                int right = (2*num)-j;
                int mn = Math.min(Math.min(top,bottom),Math.min(left,right));
                System.out.print(num-mn+1+" ");
            }
            System.out.println();
        }
    }
    public static void patternTwentyOne(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                if(i==1 || j== 1 || i == num || j == num){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void patternTwenty(int num){
        for(int i=1;i<=num*2-1;i++){
            if(i<=num){
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }for(int j=1;j<=(num-i)*2;j++){
                    System.out.print(" ");
                }for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
            }else{
                int end = i%num;
                for(int j=1;j<=num-end;j++){
                    System.out.print("*");
                }for(int j=1;j<=end*2;j++){
                    System.out.print(" ");
                }for(int j=1;j<=num-end;j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void patternNineteen(int num){
        for(int i=1;i<=num*2;i++){
            if(i<=num){
                for(int j=1;j<=num-i+1;j++){
                    System.out.print("*");
                }
                for(int j=1;j<=(i-1)*2;j++){
                    System.out.print(" ");
                }for(int j=1;j<=num-i+1;j++){
                    System.out.print("*");
                }

            }else{
                int end = i%num==0?num:i%num;
                for(int j=1;j<=end;j++){
                    System.out.print("*");
                }for(int j=1;j<=(num-end)*2;j++){
                    System.out.print(" ");
                }for(int j=1;j<=end;j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void patternEighteen(int num){
        for(int i=1;i<=num;i++){
            char ch = (char)('A'+num - i);
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
    public static void patternSeventeen(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num-i;j++){
                System.out.print(" ");
            }
            char ch=64;
            for(int j=1;j<=i*2-1;j++){
                if(j>i)

                    System.out.print(--ch);
                else
                    System.out.print(++ch);

            }
            System.out.println();
        }
    }
    public static void patternSixteen(int num){
        for(int i=1;i<=num;i++){
            int ch = 'A' +i - 1;
            for(int j=1;j<=i;j++){
                System.out.print((char)ch);
            }
            System.out.println();
        }
    }
    public static void patternFifteen(int num){
        for(int i=1;i<=num;i++){
            char ch = 'A';
            for(int j=(num-i)+1;j>=1;j--){
                System.out.print(ch++);
            }
            System.out.println();
        }
    }
    public static void patternFourteen(int num){
        for(int i=1;i<=num;i++){
            char ch='A';
            for(int j=1;j<=i;j++){

                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
    public static void patternThirteen(int num){
        int count=1;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }
    public static void patternTwelve(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=1;j<=(num-i)*2;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void patternEleven(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
    public static void patternTenAlternate(int num){
        for(int i=1;i<=num*2-1;i++){
            int end =i>num?(num*2)-i:i;
            for(int j=1;j<=end;j++){
                System.out.print("*");

            }
            System.out.println();
        }
    }
    public static void patternTen(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<num;i++){
            for(int j=1;j<=num-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void patternNine(int num){
//        patternSeven(num);
//        patternEight(num);
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num-i;j++){
                System.out.print(" ");
            }for(int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(num-i+1)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void patternEight(int num){
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(num+1-i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void patternSeven(int num){
        for(int i=1;i<=num;i++) {
            for(int j=1;j<=num-i;j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
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
