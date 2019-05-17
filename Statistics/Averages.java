/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chinemeremenumah
 */
public class Averages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        int[] X = new int[N];
        for(int i=0; i<N; i++){
            X[i] = s.nextInt();
        }
                
        System.out.println(FindMean(X));
        System.out.println(FindMedian(X));
        System.out.println(FindMode(X));

    }

    private static String FindMean(int[] X) {

        int sum = 0;
        for(int x : X){
            sum+= x;
        }
        return String.format("%.1f", Double.valueOf(sum)/X.length);
    }
        
    private static String FindMedian(int[] X) {
        
        int len = X.length;
        Arrays.sort(X);
        
        if(len % 2 != 0){
            return String.format("%.1f", Double.valueOf(X[(int) len/2]));
        } else{
            double median = (X[(len/2) -1] + X[len/2])/2.0;
            return String.format("%.1f", median);
        }
    }

    private static String FindMode(int[] X) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int x: X){
            if(map.get(x) == null){
                map.put(x, 1);
            } else{
                map.replace(x, map.get(x)+1);
            }
        }
        
        int max = Collections.max(map.values());
        for(int x: X){
            if(map.get(x) != max){
                map.remove(x);
            }
        }
        System.out.println(map);
        
        return map.size() == 1 ? String.valueOf(map.keySet().toArray()[0]) :
                String.valueOf(Collections.min(map.keySet()));
    }
    
}
