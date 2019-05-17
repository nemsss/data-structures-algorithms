/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class Primality {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n));
        }
    }

    private static String isPrime(int n) {
        
        if(n<2) return "Not Prime";
        if(n==2) return "Prime";
        if(n%2 == 0) return "Not Prime";
        for(int i=3; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return "Not Prime";
            }
        }
        return "Prime";
    }
}
