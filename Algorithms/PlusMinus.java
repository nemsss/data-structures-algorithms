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
public class PlusMinus {
   
    static void plusMinus(int[] arr) {

        int len = arr.length;
        double neg=0, pos=0, zero=0;
        for(int i = 0; i < len; i++){
            if (arr[i]>0){
                pos+= 1;
            }
            else if (arr[i]<0){
                neg+= 1;
            }
            else{
                zero+= 1;
            }
        }
        
        System.out.println(pos/len);
        System.out.println(neg/len);
        System.out.println(zero/len);
    }

   
    public static void main(String[] args) {
        
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            
            plusMinus(arr);
        }
    } 

}
