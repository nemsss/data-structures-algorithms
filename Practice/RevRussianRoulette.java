/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class RevRussianRoulette {
    
    static int[] revisedRussianRoulette(int[] doors) {
       
        int min = 0;
        int max = 0;
        for(int i=0; i<doors.length; i++){
            if(doors[i] != 0){
                max++;
                doors[i] = 0;
                if(doors[i+1] == 1){
                    max++;
                    doors[i+1] = 0;
                }
                min++;
            }
        }
        return new int []{min, max};
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + (i != result.length - 1 ? " " : ""));
        }

        in.close();
    }
}
