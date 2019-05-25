package BLP.AyoPractice;

import java.util.*;

public class LongestSubSequence {

    public static void main(String[] args) {
        List<StringBuilder> commonChars = extractCommonCharacters("BADMIGTON", "BIRNGHAM");
        System.out.println(commonChars);
        System.out.println(commonSequence(commonChars.get(0), commonChars.get(1)));
//        String longest = longestCommonSequence(commonChars);
//        System.out.println(longest);
    }

    private static String longestCommonSequence(List<StringBuilder> commonChars) {
        StringBuilder sb1 = commonChars.get(0);
        StringBuilder sb2 = commonChars.get(1);

        //Nothing common
        if(sb1.length() == 0 && sb2.length() ==0){
            return "";
        }
        //All in common
        if(sb1 == sb2){
            return sb1.toString();
        }

        int idx1 = 0, idx2 = 0;
        StringBuilder charQueue = sb1;
        while(charQueue.length() > 0){

        }

        List<StringBuilder> resultSet = new ArrayList<>();



        String res = "";
        for(StringBuilder sb : resultSet){
            if(sb.length() > res.length()){
                res = sb.toString();
            }
        }

        return res;
    }

    private static String commonSequence(StringBuilder sb1, StringBuilder sb2){
        int idx2;
        StringBuilder common = new StringBuilder();
        for(int i=0; i<sb1.length(); i++){
            char c = sb1.charAt(i);
            idx2 = sb2.indexOf(Character.toString(c));
            if(idx2 != -1) {
                common.append(c);
                sb2 = new StringBuilder(sb2.substring(idx2+1));
            }
        }

        return common.toString();
    }

    //Assuming every character in the String is unique

    private static List<StringBuilder> extractCommonCharacters(String firstString, String secondString) {
        char[] firstStringCharArr = firstString.toCharArray();
        Set<Character> firstStringSet = new HashSet<>();
        for (char ch : firstStringCharArr) {
            firstStringSet.add(ch);
        }

        char[] secondStringCharArr = secondString.toCharArray();
        Set<Character> secondStringSet = new HashSet<>();
        for (char ch : secondStringCharArr) {
            secondStringSet.add(ch);
        }

        StringBuilder firstSetCommonCharacters = new StringBuilder();
        for (char ch : firstStringCharArr) {
            if (secondStringSet.contains(ch)) {
                firstSetCommonCharacters.append(ch);
            }
        }

        StringBuilder secondSetCommonCharacters = new StringBuilder();
        for (char ch : secondStringCharArr) {
            if (firstStringSet.contains(ch)) {
                secondSetCommonCharacters.append(ch);
            }
        }

        return Arrays.asList(firstSetCommonCharacters, secondSetCommonCharacters);
    }


}
