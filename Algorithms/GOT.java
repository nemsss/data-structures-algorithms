package Algorithms;

import java.util.HashSet;
import java.util.Set;

public class GOT {

    public static void main(String[] args){
        System.out.println(gameOfThrones("cdefghmnopqrstuvw"));
        System.out.println(gameOfThrones("aabbddg"));
        System.out.println(gameOfThrones("aabbddgt"));
    }

    private static String gameOfThrones(String s) {
        Set<Character> test = new HashSet<>();
        for(char c : s.toCharArray()){
            if(test.contains(c)){
                test.remove(c);
            } else {
                test.add(c);
            }
        }

        return test.size()<=1 ? "YES" : "NO";
    }
}
