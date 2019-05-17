/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class HourGlass {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = 6;
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int i_j=0; i_j < n; i_j++){
                a[a_i][i_j] = in.nextInt();
            }
        }
        System.out.println(maxHourglassSum(a));
    }

    static int maxHourglassSum(int[][] a) {
        
        int max = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                int newSum= a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                if(i==0 && j==0) max = newSum;
                else max = newSum > max ? newSum : max;
            }
        }
        return max;
    }
    
    
}
