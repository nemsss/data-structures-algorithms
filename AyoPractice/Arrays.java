package AyoPractice;

import java.util.*;

public class Arrays {

    public static void main (String[] args){
        System.out.println(java.util.Arrays.deepToString(findSumPairs(new int[]{1, 2, 45, 5, 6}, 6)));
        System.out.println(java.util.Arrays.deepToString(findSumPairs(new int[]{0, 2, 4, 5, 9, 6}, 9)));
    }

    private static Object[] findSumPairs(int[] array, int target) {
        if(array== null || array.length==0){
            throw new IllegalArgumentException("Array can no be empty");
        }

        //Add to checker set
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> checker = new HashSet<>();
        for(int num : array){
            checker.add(num);
        }
        //Checking for pairs
        // Add to resulting set it there's a match

        // 0 2 4 5 9 6
        // 0 2 4 5 6 9
        for(int num : array){
            if(checker.contains(target - num)){
                int lesser = num < target-num ? num : target-num;
                int greater = num != lesser ? num : target-num;
                result.put(lesser, greater);
            }
        }

        return result.entrySet().toArray();
    }
}
