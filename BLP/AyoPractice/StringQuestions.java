package BLP.AyoPractice;

import java.util.Arrays;

public class StringQuestions {

    public static void main (String[] args){
        System.out.println(Arrays.toString(reverseArray("THIs is   how I figt  my battles".split(" "))));
        System.out.println(reverseString("string".toCharArray()));
        System.out.println(reverseString("stri   ng1".toCharArray()));
        System.out.println(lengthEncoding("aas snghhhtuooo"));
    }

    private static String reverseString(char [] string) {
        if(string == null || string.length == 0){
            throw new IllegalArgumentException("Array can not be empty.");
        }

        Character[] array = new Character[string.length];
        for(int i=0; i<string.length; i++){
            array[i] = string[i];
        }

        array = reverseArray(array);
        StringBuilder sb = new StringBuilder();
        for(Character c : array){
            sb.append(c);
        }

        return sb.toString();
    }

    private static <T> T[] reverseArray (T[] array){
        if(array== null || array.length == 0){
            throw new IllegalArgumentException("Array can not be empty.");
        }

        int halfLength = array.length/2;
        for(int i=0; i<halfLength; i++){        //0
            int switchWith = array.length - 1 - i;
            T temp = array[switchWith];
            array[switchWith] = array[i];
            array[i] = temp;
        }

        return array;
    }

    private static String lengthEncoding(String s){
        if(s == null || s.length()==0){
            throw new IllegalArgumentException("String cannot be blank");
        }

        StringBuilder sb = new StringBuilder();
        Character current = null;
        int count = 0;
        for(char c : s.toCharArray()){
            if(current == null){
                current = c;
                count = 1;
                continue;
            }
            if(c != current){
                sb.append(current).append(count);
                current = c;
                count = 1;
            } else {
                count+=1;
            }
        }

        sb.append(current).append(count);
        return sb.toString();
    }
}

