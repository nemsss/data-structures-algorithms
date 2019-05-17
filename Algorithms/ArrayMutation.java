package Algorithms;

import java.util.Arrays;

public class ArrayMutation {

    public static void main (String[] args){

        int [][] queries = {{1, 3, 10}, {2, 4, 15}, {3, 6, 2}};

        System.out.println(maxAfterQueries(queries, 8));
    }

    private static int maxAfterQueries(int[][] queries, int len) {

        int[] nums = new int[len];

        for( int[] query : queries){
            nums [ query[0]-1 ] += query[2];
            nums [ query[1]-1 ] -= query[2];
        }

        for( int[] query : queries){
            nums [ query[0]-1 ] += query[2];
            int endIdx = query[1];
            if(endIdx < len){
                nums [ endIdx ] -= query[2];
            } else {
                nums [ endIdx-1 ] += query[2];
            }

        }

        int maximum = 0;
        int totalSum = 0;

        for (int num : nums){
            totalSum = totalSum + num;
            if(totalSum > maximum){
                maximum = totalSum;
            }
        }

        return maximum;
    }
}
