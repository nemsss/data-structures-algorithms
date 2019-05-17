/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class LonelyInteger {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
         String v;
        v = in.nextLine();int n = in.nextInt();
        int a[] = new int[n];
        String s = "polish";
//        for(int a_i=0; a_4i < n; a_i++){
//            a[a_i] = in.nextInt();
//        }
        System.out.println(s + v);
        System.out.println(Arrays.toString(findUnique(a)));
    }
    
    static long[] findUnique (int[] a){
        
        return new long[]{1,2};
    }
}
