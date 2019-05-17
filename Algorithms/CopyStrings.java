package Algorithms;

public class CopyStrings {

    public static void main(String[] args){
        System.out.println(stringConstruction("cdefghmnopqrstuvw"));
        System.out.println(stringConstruction("aabbddg"));
        System.out.println(stringConstruction("aabbddgt"));
    }

    static int stringConstruction(String s) {
        StringBuilder p = new StringBuilder();
        int count = 0;
        int currIdx = 0;
        int endIdx = s.length();

        while(p.length() < s.length()){
            if(p.indexOf(s.substring(currIdx, endIdx)) > 0){

            }
        }

        return count;
    }
}
