/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class IQRange {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] Num = new int[N];
        int[] Weights = new int[N];
        int len =0;

        for (int i = 0; i < N; i++) {
            Num[i] = s.nextInt();
        }
        for (int i = 0; i < N; i++) {
            Weights[i] = s.nextInt();
            len+= Weights[i];
        }
        
//        int[] Num = {6,12,8,10,20,16};
//        int[] Weights = {5,4,3,2,1,5}; int len =20;
        System.out.println(FindInterquartile(Num, Weights, len));
    }

    private static double FindInterquartile(int[] Num, int[] Weights, int len) {
        
        int[] X = new int[len];
        int Wlen = Weights.length, idx=0;
        for(int i=0; i<Wlen; i++){
            for(int j=0; j<Weights[i]; j++){
                X[idx] = Num[i];
                idx += 1;
            }
        }
    
        return CalcInterquartile(X);
    }
    
    private static double CalcInterquartile(int[] X) {
        
        int len = X.length;
        Arrays.sort(X);
        
        int[] lower = Arrays.copyOfRange(X, 0, len/2);
        int[] upper;
        
        if(len%2 == 0){
            upper = Arrays.copyOfRange(X, (len/2), len);
        }
        else{
            upper = Arrays.copyOfRange(X, (len/2)+1, len);
        }
        
        return FindMidPoint(upper) - FindMidPoint(lower);
    }
    
    private static double FindMidPoint(int[] X) {
        
        int len = X.length;
        
        if(len % 2 != 0){
            return X[(len/2)];
        } else{
            double median = (X[(len/2) -1] + X[len/2])/2;
            return median;
        }
    }
}
