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
public class Staircases {
    
    public static int countsteps(int n) {

        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 0:
                return 0;
            default:    
            return countsteps(n - 3) + countsteps(n - 2) + countsteps(n-1);
        }
    }
    
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        int s = in.nextInt();
//        int[] N = new int[s];
//        for(int a0 = 0; a0 < s; a0++){
//            N[a0] = in.nextInt();
//        }
        int []N = {32,35,33,36,36}; int s =5;
        for(int a0 = 0; a0 < s; a0++){
            System.out.println(Math.sqrt(-1.0));
            //System.out.println(countsteps(101));
        }
    }
}
