/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class BetweenTwoSets {

    private static Scanner scan = new Scanner(System.in);

    static int getTotalX(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int lcm = 0;
        if (b.length > 1) {
            int idx = b.length - 1;
            while (idx > 0) {
                lcm = lcm(b[idx], b[idx - 1]);
                idx--;
            }
        } else {
            lcm = b[0];
        }

        System.out.println("lcm: " + lcm);

        int gcd = 0;
        if (a.length > 1) {
            int idx = 0;
            int len = a.length;
            while (idx < len - 1) {
                gcd = gcd(a[idx], a[idx + 1]);
                idx++;
            }
        } else {
            gcd = a[0];
        }
        System.out.println("gcd: " + gcd);

        int res = 0;

        int last_a = a[a.length - 1];
        for (int num = lcm; num >= gcd; num--) {
            if (num % gcd == 0) {
                res++;
            }
        }

        return res;
    }

    static int gcd(int x, int y) {

        int r = 0, a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number

        if (a % b == 0) {
            return a;
        }
        
        r = b;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }

    static int lcm(int x, int y) {
        int a;
        a = (x > y) ? x : y; // a is greater number
        while (true) {
            if (a % x == 0 && a % y == 0) {
                return a;
            }
            ++a;
        }
    }

    public static void main(String[] args) {

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];
        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];
        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        System.out.println("here");

        int total = getTotalX(a, b);
        System.out.println("yoo" + total);
    }
}
