package Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Nokia3310 {

    static Map<String, String> map;

    public static void main(String [] main){
        initMap();
        System.out.println(Arrays.toString(generateWordsFrom("287")));
    }

    private static StringBuilder[] generateWordsFrom(String input) {

        int lenInput = input.length();
        String[] chars = new String[lenInput];

        // Get the values from the map
        for(int i=0; i<lenInput; i++){
            chars[i] = map.get(input.substring(i, i+1));
        }

        int total = getTotalCombinationsFrom(input);
        StringBuilder[] result = new StringBuilder[total];

        int charLimit = total;
        for(int pos=0; pos<lenInput; pos++){
            charLimit = charLimit / chars[pos].length();
            int charCount = 0;
            int currIdx = 0;
            char currChar = chars[pos].charAt(0);

            for(int wrd=0; wrd<total; wrd++){

                if(charCount >= charLimit){
                    currIdx ++;
                    currIdx = currIdx >= chars[pos].length() ? currIdx - chars[pos].length() : currIdx;
                    currChar = chars[pos].charAt(currIdx);
                    charCount = 0;
                }

                StringBuilder current = result[wrd];
                result[wrd] = current == null ? new StringBuilder().append(currChar) : current.append(currChar);
                charCount++;
            }
        }

        System.out.println("ok");
        //validate results
        return result;
    }

    private static int getTotalCombinationsFrom(String input) {

        int total = 1;
        for(Character c : input.toCharArray()){
            total*= map.get(c.toString()).length();
        }
        return total;
    }

    private static void initMap() {
        map = new HashMap<>();

        map.put("2", "abc");
        map.put("3", "def");

        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");

        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }
}
