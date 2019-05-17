package AyoPractice;

import java.util.Arrays;

public class StringQuestions {

    public static void main (String[] args){
        System.out.println(reverseString("string".toCharArray()));
        System.out.println(reverseString("string1".toCharArray()));
//        System.out.println(reverseString(null));
    }

    private static String reverseString(char [] string) {
        if(string == null || string.length == 0){
            throw new IllegalArgumentException("Array can not be empty.");
        }

        Character[] array = new Character[string.length];
        for(int i=0; i<string.length; i++){
            array[i] = string[i];
        }

        return Arrays.toString(reverseArray(array));
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
}

