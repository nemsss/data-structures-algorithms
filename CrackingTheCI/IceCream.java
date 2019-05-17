/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class IceCream {
    
    static void solve(int[] arr, int money) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            //key=price, value=flavour number
            int test = arr[i];
            if(map.containsKey(money-test)){
                System.out.println(map.get(money-test)+" "+(i+1));
                return;
            }
            map.put(test, i+1);
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for(int a0 = 0; a0 < t; a0++){
                int money = in.nextInt();
                int n = in.nextInt();
                int[] arr = new int[n];
                for(int arr_i = 0; arr_i < n; arr_i++){
                    arr[arr_i] = in.nextInt();
                }
                solve(arr, money);
            }
        }
    }
}
