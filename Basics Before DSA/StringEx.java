import java.util.Locale;

public class StringEx {
    public static void main(String... args){
        String str = new String("Pritam");
        String str2 = str.concat(" Kumar");
        char[] chars = str2.toCharArray();

        String st = new String(chars);
        System.out.println(str2.charAt(5));
        System.out.println(str2.indexOf('r',3));
        System.out.println(st);
        System.out.println(str2.toLowerCase());
        System.out.println(str2.toUpperCase());
        for(char ch: chars){
            System.out.print(ch+" ");
        }
//        System.out.println(str);
//        System.out.println(str2);
        System.out.println(palindromeCheck( "A man, a plan, a canal: Panama"));
    }

    public static boolean palindromeCheck(String str){
        str = str.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(str);
        str = str.toLowerCase(Locale.ROOT);
        System.out.println(str);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
}
