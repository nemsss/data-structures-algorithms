/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RookieRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class ExamRush {
    
    static int examRush(int[] tm, int t) {
        
        Arrays.sort(tm);System.out.println(Arrays.toString(tm));
        int len=tm.length, hours=0, chaps=0;
        for(int i=0; i<len; i++){
            if(hours+tm[i] <= t){
                hours+=tm[i];
                chaps+=1;
            }
            System.out.println(chaps);
        }
        return chaps;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int t = in.nextInt();
//        int[] tm = new int[n];
//        for(int tm_i = 0; tm_i < n; tm_i++){
//            tm[tm_i] = in.nextInt();
//        }
        int[] tm = new int[]{2,1};int t=2;
        int result = examRush(tm, t);
        System.out.println(result);
//        in.close();
    }
}
