public class CountFrequencyOfCharProblem {
    public static void main(String[] args){
        String name="pritam";
        printCountOfCharacter(name);
    }
    public static void printCountOfCharacter(String name){
        int[] countFreq = new int[26];
        for(int i=0;i<name.length();i++){
            char ch = name.charAt(i);
            countFreq[ch-97] +=1;
        }
        for(int i=0;i<countFreq.length;i++){
            if(countFreq[i]>0){
                char ch = (char) (i+97);
                System.out.print(ch+"->"+countFreq[i]+"  ");
            }
        }
    }
}
