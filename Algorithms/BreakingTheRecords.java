/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author chinemeremenumah
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int len = scores.length;
        
        int max = 0;
        int min = Integer.MIN_VALUE;
        int cMax = 0, cMin = 0;
        
        for(int i=0; i<len; i++){
            
            int score = scores[i];
            if(i==0){
                max = min = score;
                continue;
            }
            
            if(max < score){
                cMax++;
                max = score;
            }
            
            if(min > score){
                cMin++;
                min = score;
                
            }
        }
        
        return new int[]{cMax, cMin};

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}


