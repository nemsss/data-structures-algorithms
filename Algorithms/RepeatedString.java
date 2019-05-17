package Algorithms;

public class RepeatedString {

    // Complete the repeatedString function below.
    private static long repeatedString(String s, long n) {

        int len = s.length();
        long base = occurencesOfAIn(s);
        Long rem = n%len;

        long count= base*((n-rem)/len);
        //if()

        count+= rem == 0L ? 0 : occurencesOfAIn(s.substring(0, rem.intValue()));

        return count;
    }

    private static long occurencesOfAIn(String s) {
        int res = 0;
        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='a'){
                res++;
            }
        }
        return res;
    }

    public static void main (String [] main){
        System.out.println(repeatedString("aaaaa", 16));
    }
}
