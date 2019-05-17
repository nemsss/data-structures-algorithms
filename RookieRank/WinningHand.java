/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RookieRank;

import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class WinningHand {
    
    static int winningHands(int m, int x, int[] a) {
        
        int res =0, len=a.length;
        for(int i=0; i<len; i++){
            if(a[i]%m == x) res++;
        }
        for(int i=0; i<len; i++){
            int tempSum=i;
            for(int j=i+1; j<len; j++){
                tempSum+= a[j];
                if(tempSum%m == x) res++;
            }
        }
                
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = winningHands(m, x, a);
        System.out.println(result);
        in.close();
    }
}
