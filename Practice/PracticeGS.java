/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class PracticeGS {
    
    
    static String findNumber(int[] arr, int k) {
        
  
        int len = arr.length;
        
        if (len < 1 || len > 10000) { return ""; }
        for(int i=0; i<len; i++){
            if (arr[i] < 1 || arr[i] > 1000000000) {return "";}
            if (arr[i] == k) {return "YES" ;}
        }

        return "NO";
    }
    
     static int[] oddNumbers(int l, int r) {
         
        List<Integer> list = new ArrayList<>();
        
        int loops = r - l;
        for(int i=0; i<=loops; i++){
            
            if(l % 2 != 0) {list.add(l);}
            l+=1;
        }
        
        if(list.isEmpty()){ 
            return new int[0]; 
        }
        else{
            int len = list.size();
            int [] res = new int[len];
            for(int i=0; i<len; i++){
                res[i] = list.get(i);
            }

            return res;
        }

    }

    
    
    public static void main(String[] args) {
        
        int[] arr = {1234,2455,2453,24534,524234,524680};
        System.out.println(findNumber(arr, 90876));

//        System.out.println(Arrays.toString(oddNumbers(2,5)));
        
    }

    
}
