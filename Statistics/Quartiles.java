/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class Quartiles {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] X = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = s.nextInt();
        }
        System.out.println(FindQuartiles(X));
    }
    
    private static String FindQuartiles(int[] X) {
        
        int len = X.length;
        Arrays.sort(X);
        
        int q_1;
        int q_2 = FindMidPoint(X);
        int q_3;
        int[] lower = Arrays.copyOfRange(X, 0, len/2);
        int[] upper;
        
        if(len%2 == 0){
            upper = Arrays.copyOfRange(X, (len/2), len);
        }
        else{
            upper = Arrays.copyOfRange(X, (len/2)+1, len);
        }
        
        q_1 = FindMidPoint(lower);
        q_3 = FindMidPoint(upper);
        
        return q_1 + "\n" +q_2 + "\n" + q_3;
    }
    
    private static int FindMidPoint(int[] X) {
        
        int len = X.length;
        
        if(len % 2 != 0){
            return X[(len/2)];
        } else{
            int median = (X[(len/2) -1] + X[len/2])/2;
            return median;
        }
    }
    
}
