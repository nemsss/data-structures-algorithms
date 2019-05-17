/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ade;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int x_n = in.nextInt();
//        int[] arr_x = new int[x_n];
//        for (int i = 0; i < x_n; i++) {
//            arr_x[i] = in.nextInt();
//        }
//
//        int y_n = in.nextInt();
//        int[] arr_y = new int[y_n];
//        for (int i = 0; i < y_n; i++) {
//            arr_y[i] = in.nextInt();
//        }
        int[] a = {1};
        int[] b = {1, 2};
        System.out.println(dotProduct(a, b));

        in.close();
    }

    static int dotProduct(int[] x, int[] y) {

        int sum = 0;
        int len_x = x.length;
        int len_y = x.length;

        if (len_x != len_y || len_x < 1 || len_y < 1) {
            return 0;
        } else {
            for (int i = 0; i < len_x; i++) {
                sum += x[i] * y[i];
                System.out.println(sum);
            }
        }

        return sum;
    }
}
