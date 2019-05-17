/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HourRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class KthMinimum {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        System.out.println(kth_minimum(a,b,x,k));
        in.close();
    }

    private static int kth_minimum(int[] a, int[] b, int x, int k) {
        
        List<Integer> list = generate_list(a, b, x);
        Collections.sort(list);
        return list.get(k+1);
    }
    
     static List<Integer> generate_list(int[] A, int[] B, int x){
        int n = A.length;
        int m = B.length;
        List<Integer> list = new ArrayList<>();
        int limit = Math.min(n, m-x);
        for(int i=1; i<=limit; i++){
            for (int j=i+x; j<=m; j++){
                list.add(A[i]*B[j]);
            }
        }
        
        return list;
    }
}
