/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class MinMaxSum {
    
     static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min=0, max=0;
        for(int i=0; i<5; i++){
            if(i<4) min+=arr[i];
            if(i>0) max+=arr[i];
        }
         System.out.println(min+" "+max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
