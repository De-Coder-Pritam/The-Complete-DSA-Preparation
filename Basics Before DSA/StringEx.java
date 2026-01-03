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
    }
}
