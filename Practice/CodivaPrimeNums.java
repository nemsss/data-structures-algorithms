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
public class CodivaPrimeNums {
    
    static int maxDifference(int startVal, int endVal) {
        
        int max = startVal, min =endVal;
        for(int i=startVal; i<=endVal; i++){
            if(isPrime(i)){
                min = i < startVal? i : startVal;
                max = i > endVal? i : endVal;
            }
        }
        
        return max-min;
    }
    
    static boolean isPrime(int x){
        
        if( x <= 1) return false;
        if( x == 2) return true;
        if( x%2 == 0) return false;

        int i = 3;
        while(i<x){
            if(x%i == 0){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int startVal = in.nextInt();
            int endVal = in.nextInt();
            int result = maxDifference(startVal, endVal);
            System.out.println(result);
        }
        in.close();
    }
}
