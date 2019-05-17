/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class StandardDev {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] X = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = s.nextInt();
        }

        System.out.println(FindStandardDev(X));

    }

    private static String FindStandardDev(int[] X) {

        double sum = 0, len = X.length;
        for(int x : X){
            sum+= x;
        }
        double mean = sum/len;
        sum = 0;
        for(int x : X){
            sum += Math.pow((x-mean),2);
        }
        
        return String.format("%.1f", Math.pow((sum/len),0.5));
    }
}
