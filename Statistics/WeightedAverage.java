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
public class WeightedAverage {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] X = new int[N];
        int[] W = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = s.nextInt();
        }

        for (int i = 0; i < N; i++) {
            W[i] = s.nextInt();
        }
        System.out.println(FindWeightedMean(X, W));

    }

    private static String FindWeightedMean(int[] X, int[] W) {

        double sum = 0, weight = 0;
        int len = X.length;
        for (int i = 0; i < len; i++) {
            sum += (X[i] * W[i]);
            weight += W[i];
        }
        return String.format("%.1f", sum / weight);
    }
}
