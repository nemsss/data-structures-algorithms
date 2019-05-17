package Algorithms;

import java.util.*;

public class Anagram {

    static int anagram(String s) {

        if (s.length() % 2 != 0) {
            return -1;
        }

        char[] c1 = s.substring(0, s.length() / 2).toCharArray();
        char[] c2 = s.substring(s.length() / 2).toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        int res = 0;
        int half = s.length() / 2 - 1;
        for (int i = 0; i <= half; i++) {
            if (c2[i] != c1[i]) {
                res++;
            }
        }

        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));
        return res;
    }

    static int anagram1(String s) {

        int len = s.length();

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < len / 2; i++) {
            char c = s.charAt(i);
            if (m1.containsKey(c)) {
                m1.replace(c, m1.get(c) + 1);
            } else {
                m1.put(c, 1);
            }
        }

        for (int i = len / 2; i < len; i++) {
            char c = s.charAt(i);
            if (m2.containsKey(c)) {
                m2.replace(c, m2.get(c) + 1);
            } else {
                m2.put(c, 1);
            }
        }

        System.out.println(m1);
        System.out.println(m2);

        int res = 0;
        for (char c : m1.keySet()) {
            int count = m2.containsKey(c) ? m2.get(c) : 0;
            res += Math.abs(m1.get(c) - count);
        }
        return res;
    }

    static int anagram2(String s) {
        int len = s.length();
        List<List<char[]>> allPerms = new ArrayList<>();

        for (int subSize = 1; subSize <= len; subSize++) {
            List<char[]> permSet = new ArrayList<>();

            for (int idx = 0; idx <= len - subSize; idx++) {
                permSet.add(s.substring(idx, idx + subSize).toCharArray());
            }
            allPerms.add(permSet);
        }

        int result = 0;
//        for(List<char[]> permSet : allPerms){
//            if(permSet.size() > 1){
//                Collections.sort(permSet);
//                int idx = 1;
//                char[] currentPerm = permSet.get(0);
//                int count = 1;
//                while(idx < permSet.size()){
//                    if(permSet.get(idx).equals(currentPerm) || permSet.get(idx).equals(reverse(currentPerm))){
//                        count++;
//                    } else {
//                        currentPerm = permSet.get(idx);
//                        if(count > 1){
//                            result += (count * count-1)/2;
//                        }
//                        count = 1;
//                    }
//                    idx++;
//                }
//            }
//        }
        return result;
    }

    private static String reverse(String currentPerm) {
        if(currentPerm == null){ return null;}
        return new StringBuilder(currentPerm).reverse().toString();
    }

    public static void main(String[] args) {
        //aaabbb
        //ab
        //abc
        //mnop
        //xyyx


        System.out.println(anagram2("xaxbbbxx"));
        System.out.println(anagram2("ifailuhkqq"));//3
        System.out.println(anagram2("kkkk"));//10
        System.out.println(anagram2("abba"));//4
        System.out.println(anagram2("cdcd"));//5
//        System.out.println(anagram("asdfjoieufoa"));
//        System.out.println(anagram("fdhlvosfpafhalll"));
//        System.out.println(anagram("mvdalvkiopaufl"));
    }
}
