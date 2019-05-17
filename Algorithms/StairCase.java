/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class StairCase {
    
    static void staircase(int n) {
        
        String rs ="";
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j<=n-i) System.out.print(" ");
                else System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
