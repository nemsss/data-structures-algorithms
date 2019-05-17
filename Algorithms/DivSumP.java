/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class DivSumP {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

    private static int count(int k, int n, int[] arr) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int divisibleSumPairs(int n, int k, int[] arr) {

        int res = 0;

        // creates a map of possible modulo values and how often they occur
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer key = arr[i] % k;
            if (map.containsKey(key)) {
                int latest = map.get(key) + 1;
                map.replace(key, latest);
            } else {
                map.put(key, 1);
            }
        }

        //this counts number of combinations based on modulo values
        int limit = k % 2 == 0 ? (k / 2) + 1 : (k + 1) / 2;
        for (int i = 0; i < limit; i++) {
            
            Integer count = map.get(i);
            
            if (count != null) {
                if (i == 0) {
                    if (count == 2) {
                        res += 1;
                    } else if (count > 2) {
                        res += combination(count, 2);
                    }
                    continue;
                }

                int complement = k - i;
                int count_c = map.get(complement);
                res += count * count_c;
            }
        }

        return res;
    }

    static int combination(int n, int k) {
        return permutation(n) / (permutation(k) * permutation(n - k));
    }

    static int permutation(int i) {
        if (i == 1) {
            return 1;
        }
        return i * permutation(i - 1);
    }

}
